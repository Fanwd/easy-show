package com.glodon.easyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.glodon.easyshow.entity.DesignDatasourceEntity;

public interface DesignDatasourceRepository extends JpaRepository<DesignDatasourceEntity, Long>, JpaSpecificationExecutor<DesignDatasourceEntity> {

}