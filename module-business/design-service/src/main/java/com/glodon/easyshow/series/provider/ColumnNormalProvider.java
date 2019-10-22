package com.glodon.easyshow.series.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glodon.easyshow.design.*;
import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.enums.ChartColumnTypeEnum;
import com.glodon.easyshow.enums.ChartEnum;
import com.glodon.easyshow.pojo.*;
import com.glodon.easyshow.series.SeriesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ColumnNormalProvider
 * @Description 普通柱状图
 * @Author fanwd
 * @Date 2019/10/22 15:59
 **/
@Service
public class ColumnNormalProvider implements SeriesProvider {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ChartEnum chartType() {
        return ChartEnum.COLUMN_NORMAL;
    }

    @Override
    public ChartResult series(DesignChartDTO designChartDTO, List<Map<String, Object>> dataList) throws IOException {
        ChartResult chartResult = new ChartResult();
        chartResult.setChartType(designChartDTO.getChartType());
        chartResult.setChartStyle(designChartDTO.getChartStyle());
        chartResult.setStyle(designChartDTO.getStyle());

        String design = designChartDTO.getDesign();
        ChartColumnDesign chartColumnDesign = objectMapper.readValue(design, ChartColumnDesign.class);

        XAxisConfig xAxisConfig = chartColumnDesign.getxAxisConfig();
        List<YAxisConfig> yAxisConfigList = chartColumnDesign.getyAxisConfig();

        // 计算一级分类
        TypeField typeField = xAxisConfig.getTypeField();
        String field = typeField.getField();
        XAxis xAxis = new XAxis();
        List<String> xDataList = new ArrayList<>();
        xAxis.setData(xDataList);
        xAxis.setxAxisField(field);

        dataList.forEach(map -> {
            Object name = map.get(field);
            if (!xDataList.contains(String.valueOf(name))) {
                xDataList.add(String.valueOf(name));
            }
        });
        chartResult.setxAxis(xAxis);
        chartResult.setyAxis(new YAxis());

        // 计算二级分类
        Legend legend = new Legend();
        List<String> legendDataList = new ArrayList<>();
        legend.setData(legendDataList);
        boolean hasSeconedType = false;
        SeriesField seriesField = xAxisConfig.getSeriesField();
        if (seriesField != null && seriesField.getField() != null) {
            hasSeconedType = true;
        }
        if (hasSeconedType) {
            String seriesFieldId = seriesField.getField();
            dataList.forEach(map -> {
                Object name = map.get(seriesFieldId);
                legendDataList.add(String.valueOf(name));
            });
        } else {
            if (!CollectionUtils.isEmpty(yAxisConfigList)) {
                for (YAxisConfig yAxisConfig : yAxisConfigList) {
                    if (yAxisConfig.getIsVisible()) {
                        legendDataList.add(yAxisConfig.getShowName());
                    }
                }
            }
        }
        chartResult.setLegend(legend);

        // 计算系列
        List<Series> seriesList;
        if (hasSeconedType) {
            seriesList = this.calcDynamicSeries();
        } else {
            seriesList = this.calcFixedSeries(xAxis, yAxisConfigList, dataList);
        }
        chartResult.setSeries(seriesList);
        return chartResult;
    }

    private List<Series> calcFixedSeries(XAxis xAxis, List<YAxisConfig> yAxisConfigList, List<Map<String, Object>> dataList) {
        List<Series> seriesList = new ArrayList<>();
        String xAxisField = xAxis.getxAxisField();
        List<String> xAxisDataList = xAxis.getData();
        for (YAxisConfig yAxisConfig : yAxisConfigList) {
            if (!yAxisConfig.getIsVisible()) {
                continue;
            }
            String fieldName = yAxisConfig.getName();
            Series series = new Series();
            series.setType(ChartColumnTypeEnum.BAR.getType());
            series.setName(yAxisConfig.getShowName());
            List<Double> seriesDataList = new ArrayList<>();
            series.setData(seriesDataList);
            for (String dim : xAxisDataList) {
                // 计算方式组内求和
                Double sum = 0.0;
                for (Map<String, Object> item : dataList) {
                    Object fieldValue = item.get(fieldName);
                    if (null == fieldValue) {
                        continue;
                    }
                    String stringFieldValue = String.valueOf(fieldValue);
                    if (dim.equals(String.valueOf(item.get(xAxisField))) && !StringUtils.isEmpty(stringFieldValue)) {
                        sum += Double.valueOf(stringFieldValue);
                    }
                }
                seriesDataList.add(sum);
            }
            seriesList.add(series);
        }
        return seriesList;
    }

    private List<Series> calcDynamicSeries() {
        return null;
    }

}
