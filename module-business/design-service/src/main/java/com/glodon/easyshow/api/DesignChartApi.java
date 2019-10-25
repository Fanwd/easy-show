package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.DesignChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DesignChartApi
 * @Description 图表设计API
 * @Author fanwd
 * @Date 2019/10/17 19:02
 **/
@RestController
@Api(tags = "图表设计API")
public class DesignChartApi {

    @Autowired
    DesignChartService designChartService;

    @ApiOperation("查询图表")
    @GetMapping("/charts")
    public JsonResult<List<DesignChartDTO>> listAllChart(@ApiParam(value = "数据源ID") @RequestParam(value = "datasourceId", required = false) String datasourceId,
                                                         @ApiParam(value = "图表类型") @RequestParam(value = "chartType", required = false) String chartType) {
        List<DesignChartDTO> result = designChartService.listChart(datasourceId, chartType);
        return JsonResult.success(result);
    }

    @ApiOperation("根据ID查询图表")
    @GetMapping("/charts/{id}")
    @CrossOrigin
    public JsonResult<Optional<DesignChartDTO>> getChartById(@ApiParam(value = "图表ID", required = true) @PathVariable("id") String id) {
        Optional<DesignChartDTO> result = designChartService.getChartById(id);
        return JsonResult.success(result);
    }

    @ApiOperation("新增图表")
    @PostMapping("/charts")
    public JsonResult addChart(@ApiParam(value = "图表信息", required = true) @RequestBody DesignChartDTO designThemeDTO) {
        designChartService.addChart(designThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("修改图表")
    @PutMapping("/charts/{id}")
    public JsonResult updateChart(@ApiParam(value = "图表ID", required = true) @PathVariable("id") String id,
                                  @ApiParam(value = "图表信息", required = true) @RequestBody DesignChartDTO designThemeDTO) {
        designChartService.updateChart(id, designThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("删除图表")
    @DeleteMapping("/charts/{id}")
    public JsonResult deleteChart(@ApiParam(value = "图表ID", required = true) @PathVariable("id") String id) {
        designChartService.deleteChartById(id);
        return JsonResult.success();
    }
}
