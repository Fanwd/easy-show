package com.glodon.easyshow.pojo;

import java.util.List;

/**
 * @ClassName YAxis
 * @Description Y轴配置
 * @Author fanwd
 * @Date 2019/10/22 9:54
 **/
public class YAxis {

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "YAxis{" +
                "data=" + data +
                '}';
    }
}
