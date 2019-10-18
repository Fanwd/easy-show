package com.glodon.easyshow.dto;

import com.glodon.easyshow.entity.DesignThemeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName DesignThemeDTO
 * @Description: 主题dto
 * @Author: fanwd
 * @Date: Create in 23:09 2019/10/15
 */
@ApiModel("主题DTO")
public class DesignThemeDTO {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private String id;

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

    public DesignThemeDTO(DesignThemeEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.style = entity.getStyle();
    }

    public DesignThemeDTO() {
    }

    public DesignThemeEntity toEntity() {
        DesignThemeEntity entity = new DesignThemeEntity();
        entity.setName(this.name);
        entity.setStyle(this.style);
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "DesignThemeDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
