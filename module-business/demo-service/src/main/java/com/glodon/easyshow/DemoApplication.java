package com.glodon.easyshow;

import com.glodon.easyshow.anno.EnableSwaggerDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName DemoApplication
 * @Description 示例服务
 * @Author fanwd
 * @Date 2019/10/18 23:12
 **/
@SpringBootApplication
@EnableSwaggerDoc(groupName = "示例服务", prefix = "com.glodon.easyshow.api")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
