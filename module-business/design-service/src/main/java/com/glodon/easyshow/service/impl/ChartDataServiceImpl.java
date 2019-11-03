package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.dto.DesignChartDataDTO;
import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.enums.SeriesByEnum;
import com.glodon.easyshow.series.SeriesManager;
import com.glodon.easyshow.service.ChartDataService;
import com.glodon.easyshow.service.DesignChartService;
import com.glodon.easyshow.service.DesignDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @ClassName ChartDataServiceImpl
 * @Description 图表数据
 * @Author fanwd
 * @Date 2019/10/22 16:10
 **/
@Service
@Transactional(readOnly = true)
public class ChartDataServiceImpl implements ChartDataService {

    @Autowired
    private DesignChartService designChartService;

    @Autowired
    private DesignDatasourceService designDatasourceService;

    @Autowired
    private SeriesManager seriesManager;

    @Override
    public DesignChartDataDTO getResultById(String id) {
        Optional<DesignChartDTO> designChartDtoOptional = designChartService.getChartById(id);
        if (!designChartDtoOptional.isPresent()) {
            // 未查到图表信息
            return null;
        }
        DesignChartDTO designChartDTO = designChartDtoOptional.get();

        String datasourceId = designChartDTO.getDatasourceId();
        Optional<DesignDatasourceDTO> datasourceDtoOptional = designDatasourceService.getDatasourceById(datasourceId);
        if (!datasourceDtoOptional.isPresent()) {
            // 前端计算
            return new DesignChartDataDTO(designChartDTO, SeriesByEnum.FRONT_SEIRES.getType(), null);
        }
        DesignDatasourceDTO designDatasourceDTO = datasourceDtoOptional.get();

        // 开始计算
        Object result = seriesManager.seriesData(designChartDTO, designDatasourceDTO);

        if (null == result) {
            // 前端计算
            return new DesignChartDataDTO(designChartDTO, SeriesByEnum.FRONT_SEIRES.getType(), null);
        }

        return new DesignChartDataDTO(designChartDTO, SeriesByEnum.BACKEND_SERIES.getType(), result);
    }
}
