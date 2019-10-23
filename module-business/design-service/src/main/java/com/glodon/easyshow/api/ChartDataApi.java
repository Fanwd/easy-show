package com.glodon.easyshow.api;

import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.ChartDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ChartDataApi
 * @Description 序列化结果
 * @Author fanwd
 * @Date 2019/10/22 16:06
 **/
@RestController
@Api(tags = "图表数据API")
public class ChartDataApi {

    @Autowired
    private ChartDataService chartDataService;

    @ApiOperation("获取图表展示数据")
    @GetMapping("/chart_dates/{id}")
    public JsonResult<Object> series(@ApiParam("图表ID") @PathVariable("id") String id) {
        Object result = chartDataService.getResultById(id);
        return JsonResult.success(result);
    }
}
