package com.glodon.easyshow.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CustomizerCachingConfig
 * @Description 自定义缓存配置
 * @Author fanwd
 * @Date 2019/10/28 20:02
 **/
@Configuration
@ConditionalOnBean(annotation = EnableCaching.class)
public class CustomizerCachingConfig extends CachingConfigurerSupport {

    private final CacheProperties cacheProperties;

    private final ObjectMapper objectMapper;

    private final CacheManagerCustomizers customizerInvoker;

    private final RedisConnectionFactory redisConnectionFactory;

    public CustomizerCachingConfig(CacheProperties cacheProperties,
                                   ObjectMapper objectMapper,
                                   CacheManagerCustomizers customizerInvoker,
                                   RedisConnectionFactory redisConnectionFactory) {
        this.cacheProperties = cacheProperties;
        this.objectMapper = objectMapper;
        this.customizerInvoker = customizerInvoker;
        this.redisConnectionFactory = redisConnectionFactory;
    }

    /**
     * 自定义缓存Key生成策略
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new CustomizerKeyGenerator();
    }

    @Override
    public RedisCacheManager cacheManager() {

        RedisCacheWriter cacheWriter = new CustomizerRedisCacheWriter(redisConnectionFactory);
        RedisCacheConfiguration defaultCacheConfiguration = customRedisCacheConfiguration();

        Map<String, RedisCacheConfiguration> initialCaches = new LinkedHashMap<>();
        List<String> cacheNames = this.cacheProperties.getCacheNames();
        if (!cacheNames.isEmpty()) {
            Map<String, RedisCacheConfiguration> cacheConfigMap = new LinkedHashMap<>(cacheNames.size());
            cacheNames.forEach(it -> cacheConfigMap.put(it, defaultCacheConfiguration));
            initialCaches.putAll(cacheConfigMap);
        }
        RedisCacheManager cm = new CustomizerCacheManager(cacheWriter, defaultCacheConfiguration, initialCaches, Boolean.TRUE);
        // 设置事务
        cm.setTransactionAware(true);

        return this.customizerInvoker.customize(cm);
    }

    /**
     * 修改缓存序列化方式
     */
    public RedisCacheConfiguration customRedisCacheConfiguration() {

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
