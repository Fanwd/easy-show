package com.glodon.easyshow.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @ClassName RequestInfo
 * @Description 请求信息
 * @Author fanwd
 * @Date 2019/10/18 20:01
 **/
@ApiModel("请求信息")
public class RequestInfo {

    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    private String url;
    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    private String method;
    /**
     * 请求头
     */
    @ApiModelProperty("请求头")
    private Map<String, String> headers;
    /**
     * 请求body
     */
    @ApiModelProperty("请求body")
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

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
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
        return "RequestInfo{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}
