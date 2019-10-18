package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.DesignDatasourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DesignDatasourceApi
 * @Description 数据源API
 * @Author fanwd
 * @Date 2019/10/14 20:13
 **/
@RestController
@Api(tags = "数据源API")
public class DesignDatasourceApi {

    @Autowired
    DesignDatasourceService designDatasourceService;

    @ApiOperation("获取所有数据源")
    @GetMapping("/datasources")
    public JsonResult<List<DesignDatasourceDTO>> listAllDatasource() {
        List<DesignDatasourceDTO> result = designDatasourceService.listAll();
        return JsonResult.success(result);
    }

    @ApiOperation("根据ID查询数据源")
    @GetMapping("/datasources/{id}")
    public JsonResult<Optional<DesignDatasourceDTO>> getDatasourceById(@ApiParam("数据源ID") @PathVariable("id") String id) {
        Optional<DesignDatasourceDTO> result = designDatasourceService.getDatasourceById(id);
        return JsonResult.success(result);
    }

    @ApiOperation("新增数据源")
    @PostMapping("/datasources")
    public JsonResult addDatasource(@ApiParam("数据源信息") @RequestBody DesignDatasourceDTO chartThemeDTO) {
        designDatasourceService.addDatasource(chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("修改数据源")
    @PutMapping("/datasources/{id}")
    public JsonResult updateDatasource(@ApiParam("数据源ID") @PathVariable("id") String id,
                                       @ApiParam("数据源信息") @RequestBody DesignDatasourceDTO chartThemeDTO) {
        designDatasourceService.updateDatasource(id, chartThemeDTO);
        return JsonResult.success();
    }

    @ApiOperation("删除数据源")
    @DeleteMapping("/datasources/{id}")
    public JsonResult deleteDatasource(@ApiParam("数据源ID") @PathVariable("id") String id) {
        designDatasourceService.deleteDatasourceById(id);
        return JsonResult.success();
    }

}
