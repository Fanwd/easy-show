package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.ChartThemeDTO;

import java.util.List;

/**
 * @ClassName ChartThemeService
 * @Description 主题配置
 * @Author fanwd
 * @Date 2019/10/15 20:15
 **/
public interface ChartThemeService {

    /**
     * 根据ID查询主题信息
     *
     * @param id
     * @return
     */
    ChartThemeDTO getThemeById(Long id);

    /**
     * 添加主题
     *
     * @param chartThemeDTO 主题信息
     */
    void addTheme(ChartThemeDTO chartThemeDTO);

    /**
     * 更新主题
     *
     * @param id            主键ID
     * @param chartThemeDTO 主题信息
     */
    void updateTheme(Long id, ChartThemeDTO chartThemeDTO);

    /**
     * 根据ID删除主题
     *
     * @param id 主题ID
     */
    void deleteThemeById(Long id);

    /**
     * 查询所有主题
     *
     * @return
     */
    List<ChartThemeDTO> listAll();

}
