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

    String requestData(RequestInfo requestInfo) throws URISyntaxException;
}
