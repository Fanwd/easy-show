package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.pojo.ChartResult;
import com.glodon.easyshow.series.SeriesManager;
import com.glodon.easyshow.service.ChartDataService;
import com.glodon.easyshow.service.DesignChartService;
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
    private SeriesManager seriesManager;

    @Override
    public ChartResult getResultById(String id) {
        Optional<DesignChartDTO> designChartDTOOptional = designChartService.getChartById(id);
        if (!designChartDTOOptional.isPresent()) {
            // 未查到图表信息
            return null;
        }
        DesignChartDTO designChartDTO = designChartDTOOptional.get();
        return seriesManager.seriesData(designChartDTO);
    }
}
