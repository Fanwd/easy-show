package com.glodon.easyshow.enums;

/**
 * @ClassName SeriesByEnum
 * @Description 计算方
 * @Author fanwd
 * @Date 2019/10/25 10:57
 **/
public enum SeriesByEnum {

    // 前端计算
    FRONT_SEIRES(0),
    // 后端计算
    BACKEND_SERIES(1);

    private Integer type;

    SeriesByEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
