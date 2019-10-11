package com.glodon.easyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EureakApplication
 * @Description 注册中心
 * @Author fanwd
 * @Date 2019/10/11 18:44
 **/
@SpringBootApplication
@EnableEurekaServer
public class EureakApplication {

    public static void main(String[] args) {
        SpringApplication.run(EureakApplication.class, args);
    }
}
