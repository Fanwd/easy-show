package com.glodon.easyshow.enums;

/**
 * @ClassName ChartEnum
 * @Description 图表枚举类
 * @Author fanwd
 * @Date 2019/10/22 16:00
 **/
public enum ChartEnum {

    /**
     * 普通柱状图
     */
    NORMAL_BAR("normal_bar"),
    /**
     * 堆积柱状图
     */
    STACK_BAR("stack_bar");

    private String type;

    ChartEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
