package com.glodon.easyshow.dto;

/**
 * @ClassName ChartThemeDTO
 * @Description: 主题dto
 * @Author: fanwd
 * @Date: Create in 23:09 2019/10/15
 */
public class ChartThemeDTO {
    private long id;
    private String name;
    private String style;

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
}
