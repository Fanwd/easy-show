package com.glodon.easyshow;

import com.glodon.easyshow.anno.EnableSwaggerDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 20:43 2019/10/13
 */
@SpringBootApplication
@EnableSwaggerDoc(groupName = "图表服务", prefix = "com.glodon.easyshow.api")
public class ChartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChartApplication.class, args);
    }
}
