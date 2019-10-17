package com.glodon.easyshow.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JacksonConfiguration
 * @Description jackson配置
 * @Author fanwd
 * @Date 2019/10/17 20:58
 **/
@Configuration
public class JacksonConfiguration {

    /**
     * 解决前端long类型丢失精度问题
     *
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializerByType(Long.TYPE, ToStringSerializer.instance);
    }

}
