package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.ChartDesignDTO;

import java.util.List;

/**
 * @ClassName ChartDesignService
 * @Description 图表设计
 * @Author fanwd
 * @Date 2019/10/17 20:19
 **/
public interface ChartDesignService {

    /**
     * 根据ID查询图表
     *
     * @param id
     * @return
     */
    ChartDesignDTO getDesignById(Long id);

    /**
     * 添加图表
     *
     * @param chartDesignDTO 图表信息
     */
    void addDesign(ChartDesignDTO chartDesignDTO);

    /**
     * 更新图表
     *
     * @param id             主键ID
     * @param chartDesignDTO 图表信息
     */
    void updateDesign(Long id, ChartDesignDTO chartDesignDTO);

    /**
     * 根据ID删除图表
     *
     * @param id 图表ID
     */
    void deleteDesignById(Long id);

    /**
     * 查询所有图表
     *
     * @return
     */
    List<ChartDesignDTO> listAll();
}
