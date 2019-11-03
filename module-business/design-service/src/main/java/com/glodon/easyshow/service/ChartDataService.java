package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.DesignChartDataDTO;

/**
 * @ClassName ChartDataService
 * @Description 图表数据处理类
 * @Author fanwd
 * @Date 2019/10/22 16:10
 **/
public interface ChartDataService {

    /**
     * 根据图表ID获取结果
     *
     * @param id
     * @return
     */
    DesignChartDataDTO getResultById(String id);

}
