package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.DesignThemeDTO;
import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.DesignThemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DesignThemeApi
 * @Description 主题配置api
 * @Author fanwd
 * @Date 2019/10/14 19:42
 **/
@RestController
@Api(tags = {"主题API"})
public class DesignThemeApi {

    @Autowired
    DesignThemeService chartThemeService;

    @ApiOperation("获取所有主题")
    @GetMapping("/themes")
    public JsonResult<List<DesignThemeDTO>> listAllTheme() {
        List<DesignThemeDTO> result = chartThemeService.listAll();
        return JsonResult.success(result);
    }

    @ApiOperation("根据ID查询主题")
    @GetMapping("/themes/{id}")
    public JsonResult<Optional<DesignThemeDTO>> getThemeById(@ApiParam(value = "主题ID", required = true) @PathVariable("id") String id) {
        Optional<DesignThemeDTO> result = chartThemeService.getThemeById(id);
        return JsonResult.success(result);
    }

    @ApiOperation("新增主题")
    @PostMapping("/themes")
    public JsonResult addTheme(@ApiParam(value = "主题信息", required = true) @RequestBody DesignThemeDTO designThemeDTO) {
        chartThemeService.addTheme(designThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("修改主题")
    @PutMapping("/themes/{id}")
    public JsonResult updateTheme(@ApiParam(value = "主题ID", required = true) @PathVariable("id") String id,
                                  @ApiParam(value = "主题信息", required = true) @RequestBody DesignThemeDTO designThemeDTO) {
        chartThemeService.updateTheme(id, designThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("删除主题")
    @DeleteMapping("/themes/{id}")
    public JsonResult deleteTheme(@ApiParam(value = "主题ID", required = true) @PathVariable("id") String id) {
        chartThemeService.deleteThemeById(id);
        return JsonResult.success();
    }

}
