package com.glodon.easyshow.dto;

import com.glodon.easyshow.entity.DesignDatasourceEntity;
import com.glodon.easyshow.pojo.DataStructure;
import com.glodon.easyshow.pojo.RequestInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

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
     * 请求信息
     */
    @ApiModelProperty("请求信息")
    private RequestInfo requestInfo;

    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private String data;

    /**
     * 数据路径
     */
    @ApiModelProperty("数据路径")
    private String dataPath;

    /**
     * 数据结构
     */
    @ApiModelProperty("数据结构")
    private List<DataStructure> dataStructures;

    public DesignDatasourceDTO() {
    }

    public DesignDatasourceDTO(String id, String name, Integer type, RequestInfo requestInfo, String data, String dataPath, List<DataStructure> dataStructures) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.requestInfo = requestInfo;
        this.data = data;
        this.dataPath = dataPath;
        this.dataStructures = dataStructures;
    }

    public DesignDatasourceDTO(DesignDatasourceEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.requestInfo = entity.getRequestInfo();
        this.data = entity.getData();
        this.dataPath = entity.getDataPath();
        this.dataStructures = entity.getDataStructures();
    }

    public DesignDatasourceEntity toEntity() {
        DesignDatasourceEntity entity = new DesignDatasourceEntity();
        entity.setName(this.name);
        entity.setType(this.type);
        entity.setRequestInfo(this.requestInfo);
        entity.setData(this.data);
        entity.setDataPath(this.dataPath);
        entity.setDataStructures(this.dataStructures);
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

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public List<DataStructure> getDataStructures() {
        return dataStructures;
    }

    public void setDataStructures(List<DataStructure> dataStructures) {
        this.dataStructures = dataStructures;
    }

    @Override
    public String toString() {
        return "DesignDatasourceDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", requestInfo=" + requestInfo +
                ", data='" + data + '\'' +
                ", dataPath='" + dataPath + '\'' +
                ", dataStructures=" + dataStructures +
                '}';
    }
}
