package com.glodon.easyshow.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RequestInfoDTO
 * @Description 请求信息DTO
 * @Author fanwd
 * @Date 2019/10/18 16:28
 **/
@ApiModel("请求信息")
public class RequestInfoDTO {

    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求头
     */
    private List<Map<String, String>> headers;
    /**
     * 请求body
     */
    private String body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Map<String, String>> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Map<String, String>> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RequestInfoDTO{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}
