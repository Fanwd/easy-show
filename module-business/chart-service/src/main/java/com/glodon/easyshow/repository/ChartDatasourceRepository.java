package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.ChartDatasourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: fanwd
 * @Description: 数据源配置
 * @Date: Create in 23:57 2019/10/14
 */
public interface ChartDatasourceRepository extends JpaRepository<ChartDatasourceEntity, Long> {
}
