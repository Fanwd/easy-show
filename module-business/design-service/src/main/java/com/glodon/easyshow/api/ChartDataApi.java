package com.glodon.easyshow.api;

import com.glodon.easyshow.pojo.ChartResult;
import com.glodon.easyshow.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ApiOperation("获取图表展示数据")
    @GetMapping("/chart_dates")
    public JsonResult<ChartResult> series(@ApiParam("图表ID") @RequestParam("id") String id) {



        return JsonResult.success();
    }
}