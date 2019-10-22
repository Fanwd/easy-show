package com.glodon.easyshow.pojo;

import java.util.List;

/**
 * @ClassName ChartResult
 * @Description 图表计算结果
 * @Author fanwd
 * @Date 2019/10/19 15:35
 **/
public class ChartResult {

    /**
     * 图表类型
     */
    private String chartType;
    /**
     * 图表风格
     */
    private String chartStyle;
    /**
     * 图表样式
     */
    private String style;
    /**
     * 图例
     */
    private Legend legend;

    /**
     * x轴
     */
    private XAxis xAxis;

    /**
     * y轴
     */
    private YAxis yAxis;

    /**
     * 系列
     */
    private List<Series> series;

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getChartStyle() {
        return chartStyle;
    }

    public void setChartStyle(String chartStyle) {
        this.chartStyle = chartStyle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public YAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(YAxis yAxis) {
        this.yAxis = yAxis;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "ChartResult{" +
                "chartType='" + chartType + '\'' +
                ", chartStyle='" + chartStyle + '\'' +
                ", style='" + style + '\'' +
                ", legend=" + legend +
                ", xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                ", series=" + series +
                '}';
    }
}
