package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.ScheTaskInfoEntity;
import com.glodon.easyshow.repository.ScheTaskInfoRepository;
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
    ScheTaskInfoRepository scheTaskInfoRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        ScheTaskInfoEntity one = scheTaskInfoRepository.getOne(1L);
        return one.getName();
    }
}
