package com.glodon.easyshow.design;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName YAxisConfig
 * @Description y轴配置
 * @Author fanwd
 * @Date 2019/10/19 14:47
 **/
public class YAxisConfig {

    /**
     * 指标类型
     */
    private String type;
    /**
     * 指标名称
     */
    private String name;
    /**
     * 展示类型
     */
    private String showType;
    /**
     * 显示位置
     */
    private Integer yIndex;
    /**
     * 别名
     */
    private String aliasName;
    /**
     * 计算类型
     */
    private String calcType;
    /**
     * 是否显示
     */
    private Boolean isVisible;
    /**
     * 过滤配置
     */
    private List<Filter> filter;

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

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public Integer getyIndex() {
        return yIndex;
    }

    public void setyIndex(Integer yIndex) {
        this.yIndex = yIndex;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getCalcType() {
        return calcType;
    }

    public void setCalcType(String calcType) {
        this.calcType = calcType;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public List<Filter> getFilter() {
        return filter;
    }

    public void setFilter(List<Filter> filter) {
        this.filter = filter;
    }

    /**
     * 获取显示名称
     *
     * @return
     */
    public String getShowName() {
        // 优先取别名，如果没有，则用字段名
        if (!StringUtils.isEmpty(this.aliasName)) {
            return this.aliasName;
        }
        return this.name;
    }

    @Override
    public String toString() {
        return "YAxisConfig{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", showType='" + showType + '\'' +
                ", yIndex=" + yIndex +
                ", aliasName='" + aliasName + '\'' +
                ", calcType='" + calcType + '\'' +
                ", isVisible=" + isVisible +
                ", filter=" + filter +
                '}';
    }
}
