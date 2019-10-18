package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.DesignChartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DesignChartRepository extends MongoRepository<DesignChartEntity, String> {

}