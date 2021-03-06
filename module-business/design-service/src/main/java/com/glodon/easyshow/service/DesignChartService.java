package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.DesignChartDTO;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DesignChartService
 * @Description 图表设计
 * @Author fanwd
 * @Date 2019/10/17 20:19
 **/
public interface DesignChartService {

    /**
     * 根据ID查询图表
     *
     * @param id 图表ID
     * @return
     */
    Optional<DesignChartDTO> getChartById(String id);

    /**
     * 添加图表
     *
     * @param designChartDTO 图表信息
     */
    void addChart(DesignChartDTO designChartDTO);

    /**
     * 更新图表
     *
     * @param id             主键ID
     * @param designChartDTO 图表信息
     */
    void updateChart(String id, DesignChartDTO designChartDTO);

    /**
     * 根据ID删除图表
     *
     * @param id 图表ID
     */
    void deleteChartById(String id);

    /**
     * 查询图表
     *
     * @param datasourceId 数据源ID
     * @param chartType    图表类型
     * @return
     */
    List<DesignChartDTO> listChart(String datasourceId, String chartType);
}
