package com.glodon.easyshow.entity;

import com.glodon.easyshow.pojo.DataStructure;
import com.glodon.easyshow.pojo.RequestInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 数据源信息
 */
@Document("design_datasource")
public class DesignDatasourceEntity {

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
     * 请求信息
     */
    @Field("request_info")
    private RequestInfo requestInfo;

    /**
     * 数据
     */
    @Field("data")
    private String data;

    /**
     * 数据路径
     */
    @Field("data_path")
    private String dataPath;

    /**
     * 数据结构
     */
    @Field("data_structures")
    private List<DataStructure> dataStructures;

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
        return "DesignDatasourceEntity{" +
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