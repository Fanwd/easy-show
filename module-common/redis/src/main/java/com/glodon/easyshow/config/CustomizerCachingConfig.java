package com.glodon.easyshow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @ClassName CustomizerCachingConfig
 * @Description 自定义缓存配置
 * @Author fanwd
 * @Date 2019/10/28 20:02
 **/
@Configuration
@ConditionalOnBean(annotation = EnableCaching.class)
public class CustomizerCachingConfig extends CachingConfigurerSupport {

    /**
     * 自定义缓存Key生成策略
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new CustomizerKeyGenerator();
    }

    /**
     * 修改缓存序列化方式
     *
     * @see org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     * @param cacheProperties
     * @param objectMapper
     * @return
     */
    @Bean
    public RedisCacheConfiguration customRedisCacheConfiguration(CacheProperties cacheProperties, ObjectMapper objectMapper) {

        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

        // 设置value序列化方式
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        serializer.setObjectMapper(objectMapper);
        RedisSerializationContext.SerializationPair<Object> serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(serializer);

        config = config.serializeValuesWith(serializationPair);

        if (redisProperties.getTimeToLive() != null) {
            config = config.entryTtl(redisProperties.getTimeToLive());
        }
        if (redisProperties.getKeyPrefix() != null) {
            // 自定义prefix规则
            config = config.computePrefixWith((cacheName -> redisProperties.getKeyPrefix() + ":" + cacheName + ":"));
        }
        if (!redisProperties.isCacheNullValues()) {
            config = config.disableCachingNullValues();
        }
        if (!redisProperties.isUseKeyPrefix()) {
            config = config.disableKeyPrefix();
        }
        return config;
    }
}
