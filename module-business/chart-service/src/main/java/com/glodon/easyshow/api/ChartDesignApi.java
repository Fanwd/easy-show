package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.ChartDesignDTO;
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
 * @ClassName ChartDesignApi
 * @Description 图表设计API
 * @Author fanwd
 * @Date 2019/10/17 19:02
 **/
@RestController
@Api(tags = "图表设计API")
public class ChartDesignApi {

    @Autowired
    ChartThemeService chartThemeService;

    @ApiOperation("获取所有图表")
    @GetMapping("/designs")
    public JsonResult<List<ChartThemeDTO>> listAllTheme() {
        List<ChartThemeDTO> result = chartThemeService.listAll();
        return JsonResult.success(result);
    }

    @ApiOperation("根据ID查询图表")
    @GetMapping("/designs/{id}")
    public JsonResult<Optional<ChartThemeDTO>> getThemeById(@ApiParam("图表ID") @PathVariable("id") Long id) {
        Optional<ChartThemeDTO> result = chartThemeService.getThemeById(id);
        return JsonResult.success(result);
    }

    @ApiOperation("新增图表")
    @PostMapping("/designs")
    public JsonResult addTheme(@ApiParam("图表信息") @RequestBody ChartThemeDTO chartThemeDTO) {
        chartThemeService.addTheme(chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("修改图表")
    @PutMapping("/designs/{id}")
    public JsonResult updateTheme(@ApiParam("图表ID") @PathVariable("id") Long id, @ApiParam("图表信息") @RequestBody ChartThemeDTO chartThemeDTO) {
        chartThemeService.updateTheme(id, chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("删除图表")
    @DeleteMapping("/designs/{id}")
    public JsonResult deleteTheme(@ApiParam("图表ID") @PathVariable("id") Long id) {
        chartThemeService.deleteThemeById(id);
        return JsonResult.success();
    }
}
