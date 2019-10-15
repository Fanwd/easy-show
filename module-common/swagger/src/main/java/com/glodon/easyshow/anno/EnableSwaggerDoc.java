package com.glodon.easyshow.anno;

import com.glodon.easyshow.config.SwaggerApiDocketRegister;
import com.glodon.easyshow.config.SwaggerConfiguration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @ClassName EnableSwaggerDoc
 * @Description: 启用swagger文档
 * @Author: fanwd
 * @Date: Create in 0:13 2019/10/16
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableSwagger2
@Import({SwaggerConfiguration.class, SwaggerApiDocketRegister.class})
public @interface EnableSwaggerDoc {

    String groupName();

    String prefix();
}
