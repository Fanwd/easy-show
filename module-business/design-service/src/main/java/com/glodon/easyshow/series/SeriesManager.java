package com.glodon.easyshow.series;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.enums.ChartEnum;
import com.glodon.easyshow.enums.DatasourceTypeEnum;
import com.glodon.easyshow.pojo.ChartResult;
import com.glodon.easyshow.pojo.RequestInfo;
import com.glodon.easyshow.service.DesignDatasourceService;
import com.glodon.easyshow.service.ProxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @ClassName SeriesManager
 * @Description 管理序列化
 * @Author fanwd
 * @Date 2019/10/22 10:39
 **/
@Service
public class SeriesManager {

    @Autowired
    private List<SeriesProvider> seriesProviderList;

    @Autowired
    private DesignDatasourceService designDatasourceService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(SeriesManager.class);

    /**
     * 序列化数据
     *
     * @param designChartDTO
     * @return
     */
    public ChartResult seriesData(DesignChartDTO designChartDTO) throws IOException {
        if (null == designChartDTO) {
            return null;
        }
        for (SeriesProvider seriesProvider : seriesProviderList) {
            ChartEnum chartEnum = seriesProvider.chartType();
            if (chartEnum.getType().equals(designChartDTO.getChartType()) && chartEnum.getStyle().equals(designChartDTO.getChartStyle())) {
                // 获取数据源信息
                String datasourceId = designChartDTO.getDatasourceId();
                Optional<DesignDatasourceDTO> datasource = designDatasourceService.getDatasourceById(datasourceId);
                if (null == datasource || !datasource.isPresent()) {
                    return null;
                }
                DesignDatasourceDTO datasourceDTO = datasource.get();
                Integer type = datasourceDTO.getType();
                String data = "";
                if (DatasourceTypeEnum.STATIC.getType().equals(type)) {
                    data = datasourceDTO.getData();
                } else if (DatasourceTypeEnum.DYNAMIC.getType().equals(type)) {
                    RequestInfo requestInfo = datasourceDTO.getRequestInfo();
                    try {
                        data = proxyService.requestData(requestInfo);
                    } catch (URISyntaxException e) {
                        logger.warn("代理请求异常 datasourceId[{}], requestInfo[{}]", datasourceId, requestInfo, e);
                        // 默认取缓存数据
                        data = datasourceDTO.getData();
                    }
                }
                if (StringUtils.isEmpty(data)) {
                    return null;
                }
                String dataPath = datasourceDTO.getDataPath();
                List<Map<String, Object>> dataList = readData(data, dataPath);
                if (dataList.isEmpty()) {
                    return null;
                }
                return seriesProvider.series(designChartDTO, dataList);
            }
        }
        return null;
    }

    /**
     * 根据json路径读取数据
     *
     * @param data
     * @param dataPath
     * @return
     */
    private List<Map<String, Object>> readData(String data, String dataPath) {
        try {
            List<Map<String, Object>> dataList = new ArrayList<>();
            JsonNode jsonNode = objectMapper.readTree(data);
            if (!jsonNode.isObject()) {
                return Collections.emptyList();
            }
            if (!StringUtils.isEmpty(dataPath)) {
                String[] split = dataPath.split("\\.");
                for (String path : split) {
                    if (!StringUtils.isEmpty(path) && jsonNode != null) {
                        jsonNode = jsonNode.get(path);
                    }
                }
            }
            if (jsonNode != null) {
                if (jsonNode.isArray()) {
                    dataList.addAll(objectMapper.readValue(jsonNode.toString(), List.class));
                } else if (jsonNode.isObject()) {
                    Map map = objectMapper.readValue(jsonNode.toString(), Map.class);
                    dataList.add(map);
                }
            }
            return dataList;
        } catch (IOException e) {
            logger.warn("解析数据异常 json[{}]", data, e);
            return Collections.emptyList();
        }
    }

}
