package com.glodon.easyshow.pojo;

import java.util.List;

/**
 * @ClassName Series
 * @Description 系列
 * @Author fanwd
 * @Date 2019/10/22 9:56
 **/
public class Series {

    /**
     * 样式
     */
    private String type;
    /**
     * 指标名称
     */
    private String name;
    /**
     * 指标数据
     */
    private List<Double> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Series{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
