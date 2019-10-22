package com.glodon.easyshow.series;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.enums.ChartEnum;
import com.glodon.easyshow.pojo.ChartResult;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SeriesProvicer
 * @Description 序列化提供者
 * @Author fanwd
 * @Date 2019/10/22 10:42
 **/
public interface SeriesProvider {

    ChartEnum chartType();

    ChartResult series(DesignChartDTO designChartDTO, List<Map<String, Object>> dataList) throws IOException;
}
