package com.glodon.easyshow.dto;

import com.glodon.easyshow.entity.ChartDesignEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName ChartDesignDTO
 * @Description 图表设计dto
 * @Author fanwd
 * @Date 2019/10/17 19:03
 **/
@ApiModel("图表设计DTO")
public class ChartDesignDTO {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 图表名称
     */
    @ApiModelProperty("图表名称")
    private String name;

    /**
     * 图表类型
     */
    @ApiModelProperty("图表类型")
    private String chartType;

    /**
     * 图表风格
     */
    @ApiModelProperty("图表风格")
    private String styleType;

    /**
     * 图表设计
     */
    @ApiModelProperty("图表设计信息")
    private String design;

    /**
     * 数据源id
     */
    @ApiModelProperty("数据源ID")
    private Long datasourceId;

    /**
     * 主题id
     */
    @ApiModelProperty("主题ID")
    private Long themeId;

    public ChartDesignDTO() {
    }

    public ChartDesignDTO(ChartDesignEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.chartType = entity.getChartType();
        this.styleType = entity.getStyleType();
        this.design = entity.getDesign();
        this.datasourceId = entity.getDatasourceId();
        this.themeId = entity.getThemeId();
    }

    public ChartDesignEntity toEntity() {
        ChartDesignEntity entity = new ChartDesignEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setChartType(this.chartType);
        entity.setStyleType(this.styleType);
        entity.setDesign(this.design);
        entity.setDatasourceId(this.datasourceId);
        entity.setThemeId(this.themeId);
        return entity;
    }

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
        return "ChartDesignDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chartType='" + chartType + '\'' +
                ", styleType='" + styleType + '\'' +
                ", design='" + design + '\'' +
                ", datasourceId=" + datasourceId +
                ", themeId=" + themeId +
                '}';
    }
}
