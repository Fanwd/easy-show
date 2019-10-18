package com.glodon.easyshow.dto;

import com.glodon.easyshow.entity.DesignDatasourceEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName DesignDatasourceDTO
 * @Description: 数据源dto
 * @Author: fanwd
 * @Date: Create in 23:08 2019/10/15
 */
@ApiModel("数据源DTO")
public class DesignDatasourceDTO {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 数据源名称
     */
    @ApiModelProperty("数据源名称")
    private String name;

    /**
     * 数据源类型
     */
    @ApiModelProperty("数据源类型")
    private Integer type;

    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    private String requestUrl;

    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    private String requestMethod;

    /**
     * 请求头
     */
    @ApiModelProperty("请求头")
    private String requestHeader;

    /**
     * 请求body
     */
    @ApiModelProperty("请求body")
    private String requestBody;

    /**
     * 返回body
     */
    @ApiModelProperty("返回body")
    private String responseBody;

    /**
     * 静态数据
     */
    @ApiModelProperty("静态数据")
    private String staticData;

    /**
     * 数据路径
     */
    @ApiModelProperty("数据路径")
    private String dataPath;

    public DesignDatasourceDTO() {
    }

    public DesignDatasourceDTO(DesignDatasourceEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.requestUrl = entity.getRequestUrl();
        this.requestMethod = entity.getRequestMethod();
        this.requestHeader = entity.getRequestHeader();
        this.requestBody = entity.getRequestBody();
        this.responseBody = entity.getResponseBody();
        this.staticData = entity.getStaticData();
        this.dataPath = entity.getDataPath();
    }

    public DesignDatasourceEntity toEntity() {
        DesignDatasourceEntity entity = new DesignDatasourceEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setType(this.type);
        entity.setRequestUrl(this.requestUrl);
        entity.setRequestMethod(this.requestMethod);
        entity.setRequestHeader(this.requestHeader);
        entity.setRequestBody(this.requestBody);
        entity.setResponseBody(this.responseBody);
        entity.setStaticData(this.staticData);
        entity.setDataPath(this.dataPath);
        return entity;
    }

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
        return "DesignDatasourceDTO{" +
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
