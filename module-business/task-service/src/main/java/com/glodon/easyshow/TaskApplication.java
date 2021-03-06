package com.glodon.easyshow;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @readme 异步任务服务
 * @Author: fanwd
 * @Description: 任务服务
 * @Date: Create in 21:32 2019/10/8
 */
@SpringBootApplication
public class TaskApplication {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
