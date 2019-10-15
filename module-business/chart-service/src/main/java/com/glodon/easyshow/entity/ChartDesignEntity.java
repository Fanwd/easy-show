package com.glodon.easyshow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 图表设计信息
 */
@Entity
@Table(name = "chart_design")
public class ChartDesignEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    /**
     * 图表名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 图表设计
     */
    @Column(name = "design")
    private String design;

    /**
     * 数据源id
     */
    @Column(name = "datasource_id")
    private Long datasourceId;

    /**
     * 主题id
     */
    @Column(name = "theme_id")
    private Long themeId;

    /**
     * 创建日期
     */
    @Column(name = "created_date")
    private Timestamp createdDate;

    /**
     * 最后修改日期
     */
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 最后修改人
     */
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;


}