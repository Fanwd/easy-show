package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.ChartDatasourceDTO;

import java.util.List;

/**
 * @ClassName ChartDatasourceService
 * @Description 数据源service
 * @Author fanwd
 * @Date 2019/10/17 20:20
 **/
public interface ChartDatasourceService {

    /**
     * 根据ID查询数据源信息
     *
     * @param id
     * @return
     */
    ChartDatasourceDTO getDatasourceById(Long id);

    /**
     * 添加数据源
     *
     * @param chartDatasourceDTO 数据源信息
     */
    void addTheme(ChartDatasourceDTO chartDatasourceDTO);

    /**
     * 更新数据源
     *
     * @param id                 主键ID
     * @param chartDatasourceDTO 数据源信息
     */
    void updateTheme(Long id, ChartDatasourceDTO chartDatasourceDTO);

    /**
     * 根据ID删除数据源
     *
     * @param id 数据源ID
     */
    void deleteThemeById(Long id);

    /**
     * 查询所有数据源
     *
     * @return
     */
    List<ChartDatasourceDTO> listAll();

}
