package com.glodon.easyshow.pojo;

import java.util.List;

/**
 * @ClassName XAxis
 * @Description x轴配置
 * @Author fanwd
 * @Date 2019/10/22 9:54
 **/
public class XAxis {

    String xAxisField;

    List<String> data;

    public String getxAxisField() {
        return xAxisField;
    }

    public void setxAxisField(String xAxisField) {
        this.xAxisField = xAxisField;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "XAxis{" +
                "xAxisField='" + xAxisField + '\'' +
                ", data=" + data +
                '}';
    }
}
