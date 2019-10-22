package com.glodon.easyshow.enums;

/**
 * @ClassName ChartEnum
 * @Description 图表枚举类
 * @Author fanwd
 * @Date 2019/10/22 16:00
 **/
public enum ChartEnum {

    /**
     * 柱状图-普通柱状图
     */
    COLUMN_NORMAL("column", "column_normal");

    private String type;
    private String style;

    ChartEnum(String type, String style) {
        this.type = type;
        this.style = style;
    }

    public String getType() {
        return type;
    }

    public String getStyle() {
        return style;
    }
}
