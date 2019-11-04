package com.glodon.easyshow.cache;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheWriter;

/**
 * @ClassName CustomizerRedisCache
 * @Description 修改删除缓存时支持通配符
 * @Author fanwd
 * @Date 2019/10/30 19:15
 **/
public class CustomizerRedisCache extends RedisCache {

    private final Boolean alwaysPattern;

    protected CustomizerRedisCache(RedisCache redisCache, Boolean alwaysPattern) {
        super(redisCache.getName(), redisCache.getNativeCache(), redisCache.getCacheConfiguration());
        this.alwaysPattern = alwaysPattern;
    }

    @Override
    public void evict(Object key) {
        String name = this.getName();
        RedisCacheWriter cacheWriter = this.getNativeCache();
        ConversionService conversionService = this.getCacheConfiguration().getConversionService();
        if (Boolean.TRUE.equals(alwaysPattern)) {
            // 总是使用通配符
            byte[] pattern = conversionService.convert(createCacheKey(key), byte[].class);
            cacheWriter.clean(name, pattern);
        } else {
            super.evict(key);
        }
    }
}
