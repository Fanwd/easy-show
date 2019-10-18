package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.DesignThemeDTO;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DesignThemeService
 * @Description 主题配置
 * @Author fanwd
 * @Date 2019/10/15 20:15
 **/
public interface DesignThemeService {

    /**
     * 根据ID查询主题信息
     *
     * @param id
     * @return
     */
    Optional<DesignThemeDTO> getThemeById(Long id);

    /**
     * 添加主题
     *
     * @param designThemeDTO 主题信息
     */
    void addTheme(DesignThemeDTO designThemeDTO);

    /**
     * 更新主题
     *
     * @param id            主键ID
     * @param designThemeDTO 主题信息
     */
    void updateTheme(Long id, DesignThemeDTO designThemeDTO);

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
    List<DesignThemeDTO> listAll();

}
