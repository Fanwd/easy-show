package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.ChartThemeDTO;
import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.ChartThemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    ChartThemeService chartThemeService;

    @ApiOperation("获取所有主题")
    @GetMapping("/themes")
    public JsonResult<List<ChartThemeDTO>> listAllTheme() {
        List<ChartThemeDTO> result = chartThemeService.listAll();
        return JsonResult.success(result);
    }

    @ApiOperation("根据ID查询主题")
    @GetMapping("/themes/{id}")
    public JsonResult<Optional<ChartThemeDTO>> getThemeById(@ApiParam("主题ID") @PathVariable("id") Long id) {
        Optional<ChartThemeDTO> result = chartThemeService.getThemeById(id);
        return JsonResult.success(result);
    }

    @ApiOperation("新增主题")
    @PostMapping("/themes")
    public JsonResult addTheme(@ApiParam("主题信息") @RequestBody ChartThemeDTO chartThemeDTO) {
        chartThemeService.addTheme(chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("修改主题")
    @PutMapping("/themes/{id}")
    public JsonResult updateTheme(@ApiParam("主题ID") @PathVariable("id") Long id, @ApiParam("主题信息") @RequestBody ChartThemeDTO chartThemeDTO) {
        chartThemeService.updateTheme(id, chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("删除主题")
    @DeleteMapping("/themes/{id}")
    public JsonResult deleteTheme(@ApiParam("主题ID") @PathVariable("id") Long id) {
        chartThemeService.deleteThemeById(id);
        return JsonResult.success();
    }

}
