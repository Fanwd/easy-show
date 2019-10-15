package com.glodon.easyshow.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 数据源信息
 */
@Entity
@Table(name = "chart_datasource")
public class ChartDatasourceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    /**
     * 数据源名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 数据源类型
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 请求地址
     */
    @Column(name = "request_url")
    private String requestUrl;

    /**
     * 请求方法
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 请求头
     */
    @Column(name = "request_header")
    private String requestHeader;

    /**
     * 请求body
     */
    @Column(name = "request_body")
    private String requestBody;

    /**
     * 返回body
     */
    @Column(name = "response_body")
    private String responseBody;

    /**
     * 静态数据
     */
    @Column(name = "static_data")
    private String staticData;

    /**
     * 数据路径
     */
    @Column(name = "data_path")
    private String dataPath;

    /**
     * 创建日期
     */
    @Column(name = "created_date")
    private Timestamp createdDate;

    /**
     * 最后更新日期
     */
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 最后更新人
     */
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;


}