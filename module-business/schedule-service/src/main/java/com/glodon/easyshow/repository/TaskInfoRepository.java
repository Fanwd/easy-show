package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.TaskInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 0:11 2019/10/8
 */
public interface TaskInfoRepository extends JpaRepository<TaskInfoEntity, Long> {
}
