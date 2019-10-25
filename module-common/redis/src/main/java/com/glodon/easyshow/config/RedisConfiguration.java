package com.glodon.easyshow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @ClassName RedisConfiguration
 * @Description Redis配置
 * @Author fanwd
 * @Date 2019/10/25 14:06
 **/
@Configuration
public class RedisConfiguration {

    @Autowired
    private CacheProperties cacheProperties;

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(ObjectMapper objectMapper) {

        CacheProperties.Redis redisProperties = this.cacheProperties.getRedis();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

        config = config.serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)));
        if (redisProperties.getTimeToLive() != null) {
            config = config.entryTtl(redisProperties.getTimeToLive());
        }
        if (redisProperties.getKeyPrefix() != null) {
            config = config.prefixKeysWith(redisProperties.getKeyPrefix());
        }
        if (!redisProperties.isCacheNullValues()) {
            config = config.disableCachingNullValues();
        }
        if (!redisProperties.isUseKeyPrefix()) {
            config = config.disableKeyPrefix();
        }
        return config;
    }

//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        RedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ((Jackson2JsonRedisSerializer<Object>) redisSerializer).setObjectMapper(objectMapper);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(redisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }

//    @Bean
//    public CacheManagerCustomizer<RedisCacheManager> jsonSerializeCacheCustomizer(ObjectMapper objectMapper) {
//        return cacheManager -> {
//            Map<String, RedisCacheConfiguration> config = cacheManager.getCacheConfigurations();
//
//            RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
//            RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ((Jackson2JsonRedisSerializer) redisSerializer).setObjectMapper(objectMapper);
//            RedisSerializationContext.SerializationPair serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer);
//            configuration.serializeValuesWith(serializationPair);
//
//            config.put("customizer", configuration);
//        };
//    }
}
