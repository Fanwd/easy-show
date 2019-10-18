package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.ChartDatasourceDTO;
import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.ChartDatasourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ChartDatasourceApi
 * @Description 数据源API
 * @Author fanwd
 * @Date 2019/10/14 20:13
 **/
@RestController
@Api(tags = "数据源API")
public class ChartDatasourceApi {

    @Autowired
    ChartDatasourceService chartDatasourceService;

    @ApiOperation("获取所有数据源")
    @GetMapping("/datasources")
    public JsonResult<List<ChartDatasourceDTO>> listAllTheme() {
        List<ChartDatasourceDTO> result = chartDatasourceService.listAll();
        return JsonResult.success(result);
    }

    @ApiOperation("根据ID查询数据源")
    @GetMapping("/datasources/{id}")
    public JsonResult<Optional<ChartDatasourceDTO>> getThemeById(@ApiParam("数据源ID") @PathVariable("id") Long id) {
        Optional<ChartDatasourceDTO> result = chartDatasourceService.getDatasourceById(id);
        return JsonResult.success(result);
    }

    @ApiOperation("新增数据源")
    @PostMapping("/datasources")
    public JsonResult addTheme(@ApiParam("数据源信息") @RequestBody ChartDatasourceDTO chartThemeDTO) {
        chartDatasourceService.addTheme(chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("修改数据源")
    @PutMapping("/datasources/{id}")
    public JsonResult updateTheme(@ApiParam("数据源ID") @PathVariable("id") Long id,
                                  @ApiParam("数据源信息") @RequestBody ChartDatasourceDTO chartThemeDTO) {
        chartDatasourceService.updateTheme(id, chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("删除数据源")
    @DeleteMapping("/datasources/{id}")
    public JsonResult deleteTheme(@ApiParam("数据源ID") @PathVariable("id") Long id) {
        chartDatasourceService.deleteThemeById(id);
        return JsonResult.success();
    }

}
