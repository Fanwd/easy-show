package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.TaskInfoEntity;
import com.glodon.easyshow.repository.TaskInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 0:21 2019/10/8
 */
@RestController
@RequestMapping("/jpa")
public class JpaTest {
    @Autowired
    TaskInfoRepository taskInfoRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        TaskInfoEntity one = taskInfoRepository.getOne(1L);
        return one.getName();
    }
}
