package com.glodon.easyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.glodon.easyshow.entity.ChartDatasourceEntity;

public interface ChartDatasourceRepository extends JpaRepository<ChartDatasourceEntity, Long>, JpaSpecificationExecutor<ChartDatasourceEntity> {

}