package com.glodon.easyshow.api;

import com.glodon.easyshow.dto.ChartDesignDTO;
import com.glodon.easyshow.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ChartDesignApi
 * @Description 图表设计API
 * @Author fanwd
 * @Date 2019/10/17 19:02
 **/
@RestController
@Api(tags = "图表设计API")
public class ChartDesignApi {

    /**
     * 根据id查询图表信息
     *
     * @param id 主键ID
     * @return
     */
    @ApiOperation("根据id查询图表信息")
    @GetMapping("/designs/{id}")
    public JsonResult<ChartDesignDTO> getDesignById(@PathVariable("id") Long id) {
        return JsonResult.success();
    }

}
