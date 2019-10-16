package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.ChartThemeEntity;
import com.glodon.easyshow.repository.ChartThemeRepository;
import com.glodon.easyshow.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ChartThemeApi
 * @Description 主题配置api
 * @Author fanwd
 * @Date 2019/10/14 19:42
 **/
@RestController
@Api(tags = {"主题API"})
public class ChartThemeApi {

    @Autowired
    private ChartThemeRepository chartThemeRepository;

    /**
     * 获取所有主题
     *
     * @return
     */
    @ApiOperation("获取所有主题")
    @GetMapping("/themes")
    public JsonResult<List<ChartThemeEntity>> listAllTheme() {
        List<ChartThemeEntity> themeList = chartThemeRepository.findAll();
        return JsonResult.success(themeList);
    }

}
