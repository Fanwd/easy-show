package com.glodon.easyshow.service;

import com.glodon.easyshow.pojo.RequestInfo;

import java.net.URISyntaxException;

/**
 * @ClassName ProxyService
 * @Description 代理请求
 * @Author fanwd
 * @Date 2019/10/22 11:03
 **/
public interface ProxyService {

    /**
     * 代理请求
     *
     * @param requestInfo 请求信息
     * @return 请求结果
     * @throws URISyntaxException URL解析异常
     */
    String requestData(RequestInfo requestInfo) throws URISyntaxException;
}
