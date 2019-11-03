package com.glodon.easyshow.cache;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;

import java.util.Map;

/**
 * @ClassName CustomizerCacheManager
 * @Description 定制RedisCacheManager
 * @Author fanwd
 * @Date 2019/10/30 19:14
 **/
public class CustomizerCacheManager extends RedisCacheManager {

    public CustomizerCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration, Map<String, RedisCacheConfiguration> initialCacheConfigurations, boolean allowInFlightCacheCreation) {
        super(cacheWriter, defaultCacheConfiguration, initialCacheConfigurations, allowInFlightCacheCreation);
    }

    @Override
    protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
        RedisCache redisCache = super.createRedisCache(name, cacheConfig);
        return new CustomizerRedisCache(redisCache, Boolean.TRUE);
    }
}
