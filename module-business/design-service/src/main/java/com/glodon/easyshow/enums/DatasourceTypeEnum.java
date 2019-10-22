package com.glodon.easyshow.enums;

/**
 * @ClassName DatasourceTypeEnum
 * @Description 数据源类型枚举类
 * @Author fanwd
 * @Date 2019/10/22 10:49
 **/
public enum DatasourceTypeEnum {

    // 静态数据
    STATIC(0),
    // 动态数据
    DYNAMIC(1);

    private Integer type;

    DatasourceTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
