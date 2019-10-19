package com.glodon.easyshow.design;

/**
 * @ClassName Sort
 * @Description 排序配置
 * @Author fanwd
 * @Date 2019/10/19 15:01
 **/
public class Sort {
    /**
     * 排序类型
     */
    private String sortBy;
    /**
     * 排序名称
     */
    private String sortName;
    /**
     * 排序类型
     */
    private String sortType;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sortBy='" + sortBy + '\'' +
                ", sortName='" + sortName + '\'' +
                ", sortType='" + sortType + '\'' +
                '}';
    }
}
