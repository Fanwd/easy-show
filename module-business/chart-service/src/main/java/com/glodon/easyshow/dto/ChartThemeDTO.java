package com.glodon.easyshow.dto;

import com.glodon.easyshow.entity.ChartThemeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName ChartThemeDTO
 * @Description: 主题dto
 * @Author: fanwd
 * @Date: Create in 23:09 2019/10/15
 */
@ApiModel("主题DTO")
public class ChartThemeDTO {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 主题名称
     */
    @ApiModelProperty("主题名称")
    private String name;

    /**
     * 样式
     */
    @ApiModelProperty("主题样式")
    private String style;

    public ChartThemeDTO(ChartThemeEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.style = entity.getStyle();
    }

    public ChartThemeDTO() {
    }

    public ChartThemeEntity toEntity() {
        ChartThemeEntity entity = new ChartThemeEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setStyle(this.style);
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "ChartThemeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
