package com.glodon.easyshow.service;

import com.glodon.easyshow.dto.DesignDatasourceDTO;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DesignDatasourceService
 * @Description 数据源service
 * @Author fanwd
 * @Date 2019/10/17 20:20
 **/
public interface DesignDatasourceService {

    /**
     * 根据ID查询数据源信息
     *
     * @param id
     * @return
     */
    Optional<DesignDatasourceDTO> getDatasourceById(String id);

    /**
     * 添加数据源
     *
     * @param designDatasourceDTO 数据源信息
     */
    void addDatasource(DesignDatasourceDTO designDatasourceDTO);

    /**
     * 更新数据源
     *
     * @param id                  主键ID
     * @param designDatasourceDTO 数据源信息
     */
    DesignDatasourceDTO updateDatasource(String id, DesignDatasourceDTO designDatasourceDTO);

    /**
     * 根据ID删除数据源
     *
     * @param id 数据源ID
     */
    void deleteDatasourceById(String id);

    /**
     * 查询所有数据源
     *
     * @return
     */
    List<DesignDatasourceDTO> listAll();

}
