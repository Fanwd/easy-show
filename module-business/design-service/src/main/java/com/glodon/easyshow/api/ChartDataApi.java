package com.glodon.easyshow.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glodon.easyshow.dto.DesignChartDataDTO;
import com.glodon.easyshow.redis.RedisDao;
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
    private ObjectMapper objectMapper;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private ChartDataService chartDataService;

    @ApiOperation("根据图表ID获取图表数据")
    @GetMapping("/chart_dates/{id}")
    public JsonResult<DesignChartDataDTO> series(@ApiParam("图表ID") @PathVariable("id") String id) {
        DesignChartDataDTO result = chartDataService.getResultById(id);
        return JsonResult.success(result);
    }

    @GetMapping("/chart_dates/cache")
    public JsonResult cache() {
        redisDao.set("fanwd", "fanweidong");
        return JsonResult.success();
    }
}
