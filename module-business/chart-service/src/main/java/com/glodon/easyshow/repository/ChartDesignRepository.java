package com.glodon.easyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.glodon.easyshow.entity.ChartDesignEntity;

public interface ChartDesignRepository extends JpaRepository<ChartDesignEntity, Long>, JpaSpecificationExecutor<ChartDesignEntity> {

}