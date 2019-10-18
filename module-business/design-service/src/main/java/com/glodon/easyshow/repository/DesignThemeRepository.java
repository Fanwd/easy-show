package com.glodon.easyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.glodon.easyshow.entity.DesignThemeEntity;

public interface DesignThemeRepository extends JpaRepository<DesignThemeEntity, Long>, JpaSpecificationExecutor<DesignThemeEntity> {

}