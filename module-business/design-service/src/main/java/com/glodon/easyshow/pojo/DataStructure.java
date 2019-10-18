package com.glodon.easyshow.pojo;

/**
 * @ClassName DataStructure
 * @Description 数据结构
 * @Author fanwd
 * @Date 2019/10/18 20:02
 **/
public class DataStructure {
    /**
     * 字段名称
     */
    private String field;
    /**
     * 字段别名
     */
    private String name;
    /**
     * 字段类型
     */
    private String type;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "dataStructure{" +
                "field='" + field + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
