package com.glodon.easyshow.enums;

/**
 * @ClassName ChartColumnTypeEnum
 * @Description 柱状图类型
 * @Author fanwd
 * @Date 2019/10/22 17:37
 **/
public enum ChartColumnTypeEnum {

    // 条
    BAR("bar"),
    LINE("line");
    private String type;

    ChartColumnTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
