package com.glodon.easyshow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 图表设计信息
 */
@Document("design_chart")
public class DesignChartEntity implements Serializable {

    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 图表名称
     */
    @Field("name")
    private String name;

    /**
     * 图表类型
     */
    @Field("chart_type")
    private String chartType;

    /**
     * 图表风格
     */
    @Field("style_type")
    private String styleType;

    /**
     * 图表设计
     */
    @Field("design")
    private String design;

    /**
     * 数据源id
     */
    @Field("datasource_id")
    private Long datasourceId;

    /**
     * 主题id
     */
    @Field("theme_id")
    private Long themeId;

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

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getStyleType() {
        return styleType;
    }

    public void setStyleType(String styleType) {
        this.styleType = styleType;
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

    @Override
    public String toString() {
        return "DesignChartEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chartType='" + chartType + '\'' +
                ", styleType='" + styleType + '\'' +
                ", design='" + design + '\'' +
                ", datasourceId=" + datasourceId +
                ", themeId=" + themeId +
                '}';
    }
}