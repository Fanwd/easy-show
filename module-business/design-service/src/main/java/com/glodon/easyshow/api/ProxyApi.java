package com.glodon.easyshow.api;

import com.glodon.easyshow.pojo.RequestInfo;
import com.glodon.easyshow.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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

    private static final RestTemplate restTemplate = new RestTemplate();

    /**
     * 代理请求
     *
     * @param requestInfo 请求信息
     * @return
     */
    @ApiOperation("代理请求")
    @PostMapping("/proxies")
    public JsonResult<String> proxyRequest(@ApiParam("请求信息") @RequestBody RequestInfo requestInfo) throws URISyntaxException {
        String url = requestInfo.getUrl();
        String method = requestInfo.getMethod();
        HttpHeaders httpHeaders = new HttpHeaders();
        RequestEntity requestEntity = new RequestEntity(requestInfo.getBody(), httpHeaders, HttpMethod.valueOf(method), new URI(url));
        ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
        return JsonResult.success(exchange.getBody());
    }

}
