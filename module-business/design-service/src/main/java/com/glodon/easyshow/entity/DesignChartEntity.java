package com.glodon.easyshow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
    @Field("chart_style")
    private String chartStyle;

    /**
     * 图表样式
     */
    @Field("style")
    private String style;

    /**
     * 图表设计
     */
    @Field("design")
    private String design;

    /**
     * 数据源id
     */
    @Field("datasource_id")
    @Indexed
    private String datasourceId;

    /**
     * 主题id
     */
    @Field("theme_id")
    private String themeId;

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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getChartStyle() {
        return chartStyle;
    }

    public void setChartStyle(String chartStyle) {
        this.chartStyle = chartStyle;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    @Override
    public String toString() {
        return "DesignChartEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chartType='" + chartType + '\'' +
                ", chartStyle='" + chartStyle + '\'' +
                ", style='" + style + '\'' +
                ", design='" + design + '\'' +
                ", datasourceId='" + datasourceId + '\'' +
                ", themeId='" + themeId + '\'' +
                '}';
    }
}