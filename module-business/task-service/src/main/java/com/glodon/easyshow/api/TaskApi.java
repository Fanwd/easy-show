package com.glodon.easyshow.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @readme 测试代码
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

    /**
     * 测试接口
     *
     * @param name 姓名
     * @return 用户名
     */
    @RequestMapping(name = "测试", value = "/test", method = RequestMethod.GET)
    public JsonResult<String> test(@RequestParam("name") String name) {
        return JsonResult.success();
    }

}
