package com.glodon.easyshow.api;

import com.glodon.easyshow.pojo.RequestInfo;
import com.glodon.easyshow.result.JsonResult;
import com.glodon.easyshow.service.ProxyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

/**
 * @ClassName ProxyApi
 * @Description 代理API
 * @Author fanwd
 * @Date 2019/10/18 20:18
 **/
@Api(tags = "代理请求API")
@RestController
public class ProxyApi {

    @Autowired
    private ProxyService proxyService;

    /**
     * 代理请求
     *
     * @param requestInfo 请求信息
     * @return
     */
    @ApiOperation("代理请求")
    @PostMapping("/proxies")
    public JsonResult<String> proxyRequest(@ApiParam("请求信息") @RequestBody RequestInfo requestInfo) throws URISyntaxException {
        String result = proxyService.requestData(requestInfo);
        return JsonResult.success(result);
    }

}
