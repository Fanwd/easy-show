package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.DesignThemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DesignThemeRepository extends MongoRepository<DesignThemeEntity, String> {

}