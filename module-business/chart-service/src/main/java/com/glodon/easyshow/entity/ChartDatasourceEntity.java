package com.glodon.easyshow.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 23:55 2019/10/14
 */
@Entity
@Table(name = "chart_datasource", schema = "easy_show_chart")
public class ChartDatasourceEntity {
    private long id;
    private String name;
    private Byte type;
    private String requestUrl;
    private String requestMethod;
    private String requestHeader;
    private String requestBody;
    private String responseBody;
    private String staticData;
    private String dataPath;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
    private Long createdBy;
    private Long lastModifiedBy;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "request_url")
    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Basic
    @Column(name = "request_method")
    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Basic
    @Column(name = "request_header")
    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    @Basic
    @Column(name = "request_body")
    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    @Basic
    @Column(name = "response_body")
    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Basic
    @Column(name = "static_data")
    public String getStaticData() {
        return staticData;
    }

    public void setStaticData(String staticData) {
        this.staticData = staticData;
    }

    @Basic
    @Column(name = "data_path")
    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "last_modified_date")
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Basic
    @Column(name = "created_by")
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "last_modified_by")
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChartDatasourceEntity that = (ChartDatasourceEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (requestUrl != null ? !requestUrl.equals(that.requestUrl) : that.requestUrl != null) return false;
        if (requestMethod != null ? !requestMethod.equals(that.requestMethod) : that.requestMethod != null)
            return false;
        if (requestHeader != null ? !requestHeader.equals(that.requestHeader) : that.requestHeader != null)
            return false;
        if (requestBody != null ? !requestBody.equals(that.requestBody) : that.requestBody != null) return false;
        if (responseBody != null ? !responseBody.equals(that.responseBody) : that.responseBody != null) return false;
        if (staticData != null ? !staticData.equals(that.staticData) : that.staticData != null) return false;
        if (dataPath != null ? !dataPath.equals(that.dataPath) : that.dataPath != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(that.lastModifiedDate) : that.lastModifiedDate != null)
            return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (lastModifiedBy != null ? !lastModifiedBy.equals(that.lastModifiedBy) : that.lastModifiedBy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (requestUrl != null ? requestUrl.hashCode() : 0);
        result = 31 * result + (requestMethod != null ? requestMethod.hashCode() : 0);
        result = 31 * result + (requestHeader != null ? requestHeader.hashCode() : 0);
        result = 31 * result + (requestBody != null ? requestBody.hashCode() : 0);
        result = 31 * result + (responseBody != null ? responseBody.hashCode() : 0);
        result = 31 * result + (staticData != null ? staticData.hashCode() : 0);
        result = 31 * result + (dataPath != null ? dataPath.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (lastModifiedBy != null ? lastModifiedBy.hashCode() : 0);
        return result;
    }
}
