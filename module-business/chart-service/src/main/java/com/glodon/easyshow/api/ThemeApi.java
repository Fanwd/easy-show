package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ThemeApi
 * @Description 主题配置api
 * @Author fanwd
 * @Date 2019/10/14 19:42
 **/
@RestController
@RequestMapping("/theme")
public class ThemeApi {

    /**
     * 查询所有主题
     *
     * @return
     */
    public JsonResult listAllTheme() {
        return JsonResult.success();
    }

}
