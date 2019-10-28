package com.glodon.easyshow.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CustomizerCachingConfig
 * @Description 自定义缓存配置
 * @Author fanwd
 * @Date 2019/10/28 20:02
 **/
@Configuration
public class CustomizerCachingConfig extends CachingConfigurerSupport {

    @Override
    public KeyGenerator keyGenerator() {
        return new CustomizerKeyGenerator();
    }
}
