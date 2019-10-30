package com.glodon.easyshow.api;

import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.impl.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CacheApi
 * @Description TODO
 * @Author fanwd
 * @Date 2019/10/30 9:19
 **/
@RestController
public class CacheApi {

    @Autowired
    private CacheServiceImpl cacheService;

    @GetMapping("/caches/{id}")
    public JsonResult<String> getById() {
        String result = cacheService.getById("product", "1");
        return JsonResult.success();
    }

    @GetMapping("/caches")
    public JsonResult<String> getAll() {
        String result = cacheService.getAll("product");
        return JsonResult.success();
    }

    @PostMapping("/caches/{id}")
    public JsonResult<String> updateById() {
        String result = cacheService.updateById("product", "1");
        return JsonResult.success();
    }

    @PostMapping("/caches")
    public JsonResult<String> delteAll() {
        String result = cacheService.delteAll("product");
        return JsonResult.success();
    }
}
