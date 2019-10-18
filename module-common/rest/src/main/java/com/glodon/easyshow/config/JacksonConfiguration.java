package com.glodon.easyshow.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JacksonConfiguration
 * @Description 配置jackson
 * @Author fanwd
 * @Date 2019/10/18 13:43
 **/
@Configuration
public class JacksonConfiguration {

    /**
     * 定制jackson序列化规则
     *
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder
                .serializerByType(Long.TYPE, ToStringSerializer.instance);
    }

}
