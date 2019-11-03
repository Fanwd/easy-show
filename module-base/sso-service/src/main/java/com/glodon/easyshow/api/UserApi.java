package com.glodon.easyshow.api;

import com.glodon.easyshow.result.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserApi
 * @Description: 用户信息
 * @Author: fanwd
 * @Date: Create in 23:58 2019/11/3
 */
@RestController
public class UserApi {

    @GetMapping("/users")
    public JsonResult<String> getUserInfo() {
        return JsonResult.success("OK");
    }
}
