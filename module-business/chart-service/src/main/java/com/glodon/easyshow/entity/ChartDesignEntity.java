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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Long getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(Long datasourceId) {
        this.datasourceId = datasourceId;
    }

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String toString() {
        return "ChartDesignEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", design='" + design + '\'' +
                ", datasourceId=" + datasourceId +
                ", themeId=" + themeId +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", createdBy=" + createdBy +
                ", lastModifiedBy=" + lastModifiedBy +
                '}';
    }
}