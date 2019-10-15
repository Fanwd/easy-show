package com.glodon.easyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.glodon.easyshow.entity.ChartThemeEntity;

public interface ChartThemeRepository extends JpaRepository<ChartThemeEntity, Long>, JpaSpecificationExecutor<ChartThemeEntity> {

}