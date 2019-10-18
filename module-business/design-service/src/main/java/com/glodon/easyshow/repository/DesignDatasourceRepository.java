package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.DesignDatasourceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DesignDatasourceRepository extends MongoRepository<DesignDatasourceEntity, String> {

}