package com.glodon.easyshow.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @ClassName CacheServiceImpl
 * @Description TODO
 * @Author fanwd
 * @Date 2019/10/30 9:17
 **/
@Service
@CacheConfig(cacheNames = "cacheServiceImpl")
public class CacheServiceImpl {

    @Cacheable(key="#product + ':' + #id")
    public String getById(String product, String id) {
        return "getById";
    }

    @Cacheable(key="#product + ':all'")
    public String getAll(String product) {
        return "getAll";
    }

    @Caching(evict = {
            @CacheEvict(key="#product + ':' + #id"),
            @CacheEvict(key="#product + ':all'")
    })
    public String updateById(String product, String id) {
        return "updateById";
    }

    @CacheEvict(key = "#product + ':*'")
    public String delteAll(String product) {
        return "deleteAll";
    }

}
