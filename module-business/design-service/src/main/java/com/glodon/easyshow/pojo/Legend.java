package com.glodon.easyshow.pojo;

import java.util.List;

/**
 * @ClassName Legend
 * @Description 图例
 * @Author fanwd
 * @Date 2019/10/22 9:51
 **/
public class Legend {
    /**
     * 图例列表
     */
    List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Legend{" +
                "data=" + data +
                '}';
    }
}
