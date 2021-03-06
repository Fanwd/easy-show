package com.glodon.easyshow.series;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.enums.DatasourceTypeEnum;
import com.glodon.easyshow.pojo.RequestInfo;
import com.glodon.easyshow.service.ProxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @ClassName SeriesManager
 * @Description 管理序列化
 * @Author fanwd
 * @Date 2019/10/22 10:39
 **/
@Service
public class SeriesManager implements InitializingBean {

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SeriesJsCalcProperties seriesJsCalcProperties;

    private ScriptEngine scriptEngine;
    private Invocable invocable;

    private static final Logger logger = LoggerFactory.getLogger(SeriesManager.class);

    /**
     * 序列化数据
     *
     * @param designChartDTO
     * @return
     */
    public Object seriesData(DesignChartDTO designChartDTO, DesignDatasourceDTO datasourceDTO) {
        if (null == designChartDTO) {
            return null;
        }
        // 获取数据源信息
        Integer type = datasourceDTO.getType();
        String data = "";
        if (DatasourceTypeEnum.STATIC.getType().equals(type)) {
            data = datasourceDTO.getData();
        } else if (DatasourceTypeEnum.DYNAMIC.getType().equals(type)) {
            RequestInfo requestInfo = datasourceDTO.getRequestInfo();
            try {
                data = proxyService.requestData(requestInfo);
            } catch (URISyntaxException e) {
                logger.warn("代理请求异常 datasource[{}], requestInfo[{}]", datasourceDTO, requestInfo, e);
                // 默认取缓存数据
                data = datasourceDTO.getData();
            }
        }
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        try {
            return this.series(designChartDTO, data, datasourceDTO.getDataPath());
        } catch (ScriptException | NoSuchMethodException e) {
            logger.warn("脚本执行异常designChartDTO[{}], data", designChartDTO, data, e);
        }
        return null;
    }

    private Object series(DesignChartDTO designChartDTO, String data, String dataPath) throws ScriptException, NoSuchMethodException {
        String objectName = seriesJsCalcProperties.getObjectName();
        if (StringUtils.isEmpty(objectName)) {
            return this.invocable.invokeFunction(seriesJsCalcProperties.getMethodName(), designChartDTO, data);
        } else {
            Object obj = scriptEngine.get(objectName);
            Map<String, Object> map = new HashMap<>();
            List<Map<String, Object>> dataList = this.readData(data, dataPath);
            map.put("data", dataList);
            map.put("chart", designChartDTO);
            return this.invocable.invokeMethod(obj, seriesJsCalcProperties.getMethodName(), map);
        }
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

    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化计算js
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager(this.getClass().getClassLoader());
        ScriptEngine se = scriptEngineManager.getEngineByExtension("js");
        InputStream jsStream = this.getClass().getClassLoader().getResourceAsStream(seriesJsCalcProperties.getJsName());
        if (jsStream == null) {
            throw new FileNotFoundException(seriesJsCalcProperties.getJsName());
        }
        InputStreamReader jsReader = new InputStreamReader(jsStream, StandardCharsets.UTF_8);
        if (se instanceof Compilable) {
            CompiledScript compiledScript = ((Compilable) se).compile(jsReader);
            compiledScript.eval();
            this.scriptEngine = se;
        }
        if (se instanceof Invocable) {
            this.invocable = ((Invocable) se);
        }
    }
}
