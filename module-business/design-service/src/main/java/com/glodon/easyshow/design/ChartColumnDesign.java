package com.glodon.easyshow.design;

import java.util.List;

/**
 * @ClassName ChartColumnDesign
 * @Description 柱状图设计
 * @Author fanwd
 * @Date 2019/10/19 14:32
 **/
public class ChartColumnDesign {

    /**
     * 图表类型
     */
    private String chartType;

    /**
     * 图表风格
     */
    private String chartStyle;

    /**
     * x轴配置
     */
    private XAxisConfig xAxisConfig;

    /**
     * y轴配置
     */
    private List<YAxisConfig> yAxisConfig;

    /**
     * 数据源ID
     */
    private String datasourceId;

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

    public XAxisConfig getxAxisConfig() {
        return xAxisConfig;
    }

    public void setxAxisConfig(XAxisConfig xAxisConfig) {
        this.xAxisConfig = xAxisConfig;
    }

    public List<YAxisConfig> getyAxisConfig() {
        return yAxisConfig;
    }

    public void setyAxisConfig(List<YAxisConfig> yAxisConfig) {
        this.yAxisConfig = yAxisConfig;
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    @Override
    public String toString() {
        return "ChartColumnDesign{" +
                "chartType='" + chartType + '\'' +
                ", chartStyle='" + chartStyle + '\'' +
                ", xAxisConfig=" + xAxisConfig +
                ", yAxisConfig=" + yAxisConfig +
                ", datasourceId='" + datasourceId + '\'' +
                '}';
    }
}
