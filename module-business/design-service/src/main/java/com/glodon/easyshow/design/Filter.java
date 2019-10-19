package com.glodon.easyshow.design;

/**
 * @ClassName Filter
 * @Description 过滤配置
 * @Author fanwd
 * @Date 2019/10/19 15:06
 **/
public class Filter {

    /**
     * 过滤纬度
     */
    private String filterBy;
    /**
     * 过滤名称
     */
    private String name;
    /**
     * 过滤类型
     */
    private String filterType;
    /**
     * 过滤值
     */
    private String value;

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "filterBy='" + filterBy + '\'' +
                ", name='" + name + '\'' +
                ", filterType='" + filterType + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
