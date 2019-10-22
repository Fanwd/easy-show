package com.glodon.easyshow.design;

import java.util.List;

/**
 * @ClassName TypeField
 * @Description 一级分类
 * @Author fanwd
 * @Date 2019/10/19 14:54
 **/
public class TypeField {

    /**
     * 字段
     */
    private String field;
    /**
     * 别名
     */
    private String aliasName;
    /**
     * 排序规则
     */
    private Sort sort;
    /**
     * 过滤规则
     */
    private List<Filter> filter;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<Filter> getFilter() {
        return filter;
    }

    public void setFilter(List<Filter> filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "TypeField{" +
                "field='" + field + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", sort=" + sort +
                ", filter=" + filter +
                '}';
    }
}
