package com.glodon.easyshow.dto;

import com.glodon.easyshow.entity.DesignChartEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName DesignChartDTO
 * @Description 图表设计dto
 * @Author fanwd
 * @Date 2019/10/17 19:03
 **/
@ApiModel("图表设计DTO")
public class DesignChartDTO implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 图表名称
     */
    @ApiModelProperty("图表名称")
    private String name;

    /**
     * 图表类型
     */
    @ApiModelProperty("图表类型(柱状图、饼状图)")
    private String chartType;

    /**
     * 图表风格
     */
    @ApiModelProperty("图表风格（普通柱状图、堆积柱状图）")
    private String chartStyle;

    /**
     * 图表样式
     */
    @ApiModelProperty("图表样式")
    private String style;

    /**
     * 图表设计
     */
    @ApiModelProperty("图表设计信息")
    private String design;

    /**
     * 数据源id
     */
    @ApiModelProperty("数据源ID")
    private String datasourceId;

    /**
     * 主题id
     */
    @ApiModelProperty("主题ID")
    private String themeId;

    public DesignChartDTO() {
    }

    public DesignChartDTO(DesignChartDTO designChartDTO) {
        this.id = designChartDTO.getId();
        this.name = designChartDTO.getName();
        this.chartType = designChartDTO.getChartType();
        this.chartStyle = designChartDTO.getChartStyle();
        this.style = designChartDTO.getStyle();
        this.design = designChartDTO.getDesign();
        this.datasourceId = designChartDTO.getDatasourceId();
        this.themeId = designChartDTO.getThemeId();
    }

    public DesignChartDTO(DesignChartEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.chartType = entity.getChartType();
        this.chartStyle = entity.getChartStyle();
        this.style = entity.getStyle();
        this.design = entity.getDesign();
        this.datasourceId = entity.getDatasourceId();
        this.themeId = entity.getThemeId();
    }

    public DesignChartEntity toEntity() {
        DesignChartEntity entity = new DesignChartEntity();
        entity.setName(this.name);
        entity.setChartType(this.chartType);
        entity.setChartStyle(this.chartStyle);
        entity.setStyle(this.style);
        entity.setDesign(this.design);
        entity.setDatasourceId(this.datasourceId);
        entity.setThemeId(this.themeId);
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
        return "DesignChartDTO{" +
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
