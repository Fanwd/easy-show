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
     * 图表类型
     */
    @Column(name = "chart_type")
    private String chartType;

    /**
     * 图表风格
     */
    @Column(name = "style_type")
    private String styleType;

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

    /**
     * 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 图表名称
     */
    public String getName() {
        return name;
    }

    /**
     * 图表名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 图表类型
     */
    public String getChartType() {
        return chartType;
    }

    /**
     * 图表类型
     */
    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    /**
     * 图表风格
     */
    public String getStyleType() {
        return styleType;
    }

    /**
     * 图表风格
     */
    public void setStyleType(String styleType) {
        this.styleType = styleType;
    }

    /**
     * 图表设计
     */
    public String getDesign() {
        return design;
    }

    /**
     * 图表设计
     */
    public void setDesign(String design) {
        this.design = design;
    }

    /**
     * 数据源id
     */
    public Long getDatasourceId() {
        return datasourceId;
    }

    /**
     * 数据源id
     */
    public void setDatasourceId(Long datasourceId) {
        this.datasourceId = datasourceId;
    }

    /**
     * 主题id
     */
    public Long getThemeId() {
        return themeId;
    }

    /**
     * 主题id
     */
    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    /**
     * 创建日期
     */
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    /**
     * 创建日期
     */
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 最后修改日期
     */
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * 最后修改日期
     */
    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * 创建人
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 最后修改人
     */
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * 最后修改人
     */
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String toString() {
        return "ChartDesign{id=" + id +
                ", name=" + name +
                ", chartType=" + chartType +
                ", styleType=" + styleType +
                ", design=" + design +
                ", datasourceId=" + datasourceId +
                ", themeId=" + themeId +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", createdBy=" + createdBy +
                ", lastModifiedBy=" + lastModifiedBy +
                "}";
    }
}