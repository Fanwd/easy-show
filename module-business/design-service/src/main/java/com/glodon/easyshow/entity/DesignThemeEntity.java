package com.glodon.easyshow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 主题样式
 */
@Document("design_theme")
public class DesignThemeEntity implements Serializable {

    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 主题名称
     */
    @Field("name")
    private String name;

    /**
     * 样式
     */
    @Field("style")
    private String style;

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
        return "DesignThemeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}