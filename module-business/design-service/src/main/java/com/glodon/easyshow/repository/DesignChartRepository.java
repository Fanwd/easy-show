package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.DesignChartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DesignChartRepository extends MongoRepository<DesignChartEntity, String> {

    /**
     * 根据数据源ID查询图表
     *
     * @param id 数据源ID
     * @return
     */
    List<DesignChartEntity> findByDatasourceId(String id);

}