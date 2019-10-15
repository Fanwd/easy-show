package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.ChartThemeEntity;
import com.glodon.easyshow.entity.JsonResult;
import com.glodon.easyshow.repository.ChartThemeRepository;
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
public class ChartThemeApi {

    @Autowired
    private ChartThemeRepository chartThemeRepository;

    /**
     * 查询所有主题
     *
     * @return
     */
    @GetMapping("/themes")
    public JsonResult<List<ChartThemeEntity>> listAllTheme() {
        List<ChartThemeEntity> themeList = chartThemeRepository.findAll();
        return JsonResult.success(themeList);
    }

}
