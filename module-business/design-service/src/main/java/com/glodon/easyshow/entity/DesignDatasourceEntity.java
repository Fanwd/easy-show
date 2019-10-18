package com.glodon.easyshow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 数据源信息
 */
@Document("design_datasource")
public class DesignDatasourceEntity implements Serializable {

    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 数据源名称
     */
    @Field("name")
    private String name;

    /**
     * 数据源类型
     */
    @Field("type")
    private Integer type;

    /**
     * 请求地址
     */
    @Field("request_url")
    private String requestUrl;

    /**
     * 请求方法
     */
    @Field("request_method")
    private String requestMethod;

    /**
     * 请求头
     */
    @Field("request_header")
    private String requestHeader;

    /**
     * 请求body
     */
    @Field("request_body")
    private String requestBody;

    /**
     * 返回body
     */
    @Field("response_body")
    private String responseBody;

    /**
     * 静态数据
     */
    @Field("static_data")
    private String staticData;

    /**
     * 数据路径
     */
    @Field("data_path")
    private String dataPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getStaticData() {
        return staticData;
    }

    public void setStaticData(String staticData) {
        this.staticData = staticData;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    @Override
    public String toString() {
        return "DesignDatasourceEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestHeader='" + requestHeader + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", staticData='" + staticData + '\'' +
                ", dataPath='" + dataPath + '\'' +
                '}';
    }
}