package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.ChartThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: fanwd
 * @Description: 主题配置
 * @Date: Create in 23:58 2019/10/14
 */
public interface ChartThemeRepository extends JpaRepository<ChartThemeEntity, Long> {
}
