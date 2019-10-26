package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.ComputerInfo;
import com.glodon.easyshow.repository.ComputerInfoRepository;
import com.glodon.easyshow.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DemoComputerApi
 * @Description 电脑信息
 * @Author fanwd
 * @Date 2019/10/25 23:01
 **/
@Api("电脑信息API")
@RestController
public class DemoComputerApi {

    @Autowired
    private ComputerInfoRepository computerInfoRepository;

    @ApiOperation("查询电脑信息")
    @GetMapping("/computers")
    @CrossOrigin
    public JsonResult<List<ComputerInfo>> listAllProject() {
        List<ComputerInfo> result = computerInfoRepository.listAll();
        return JsonResult.success(result);
    }
}
