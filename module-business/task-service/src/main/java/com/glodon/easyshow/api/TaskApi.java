package com.glodon.easyshow.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 23:07 2019/10/8
 */
@RestController
@RequestMapping("/task")
public class TaskApi {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "OK";
    }

}
