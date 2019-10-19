package com.glodon.easyshow.design;

/**
 * @ClassName XAxisConfig
 * @Description x轴配置
 * @Author fanwd
 * @Date 2019/10/19 14:46
 **/
public class XAxisConfig {

    /**
     * 一级分类
     */
    private TypeField typeField;

    /**
     * 二级分类
     */
    private SeriesField seriesField;

    public TypeField getTypeField() {
        return typeField;
    }

    public void setTypeField(TypeField typeField) {
        this.typeField = typeField;
    }

    public SeriesField getSeriesField() {
        return seriesField;
    }

    public void setSeriesField(SeriesField seriesField) {
        this.seriesField = seriesField;
    }

    @Override
    public String toString() {
        return "XAxisConfig{" +
                "typeField=" + typeField +
                ", seriesField=" + seriesField +
                '}';
    }
}
