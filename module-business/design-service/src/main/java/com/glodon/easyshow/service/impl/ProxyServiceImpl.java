package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.pojo.RequestInfo;
import com.glodon.easyshow.service.ProxyService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName ProxyServiceImpl
 * @Description 代理请求
 * @Author fanwd
 * @Date 2019/10/22 11:03
 **/
@Service
public class ProxyServiceImpl implements ProxyService {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String requestData(RequestInfo requestInfo) throws URISyntaxException {
        String url = requestInfo.getUrl();
        String method = requestInfo.getMethod();
        HttpHeaders httpHeaders = new HttpHeaders();
        RequestEntity requestEntity = new RequestEntity(requestInfo.getBody(), httpHeaders, HttpMethod.valueOf(method), new URI(url));
        ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
        return exchange.getBody();
    }
}
