package com.glodon.easyshow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @ClassName RedisConfiguration
 * @Description Redis配置
 * @Author fanwd
 * @Date 2019/10/25 14:06
 **/
@Configuration
public class RedisConfiguration {

    /**
     * redis缓存value由二进制改为json
     *
     * @param objectMapper
     * @return
     */
    @Bean
    @ConditionalOnBean(CacheAspectSupport.class)
    public RedisCacheConfiguration customRedisCacheConfiguration(CacheProperties cacheProperties, ObjectMapper objectMapper) {

        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        serializer.setObjectMapper(objectMapper);
        RedisSerializationContext.SerializationPair<Object> serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(serializer);

        config = config.serializeValuesWith(serializationPair);

//        config = config.serializeValuesWith(
//                RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)));
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
