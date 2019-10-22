package com.glodon.easyshow.series.provider;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.enums.ChartEnum;
import com.glodon.easyshow.pojo.ChartResult;
import com.glodon.easyshow.series.SeriesProvider;
import org.springframework.stereotype.Service;

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

    @Override
    public ChartEnum chartType() {
        return ChartEnum.COLUMN_NORMAL;
    }

    @Override
    public ChartResult series(DesignChartDTO designChartDTO, List<Map<String, Object>> dataList) {
        return null;
    }
}
