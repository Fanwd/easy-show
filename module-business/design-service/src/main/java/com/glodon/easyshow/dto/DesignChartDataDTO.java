package com.glodon.easyshow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName DesignChartDataDTO
 * @Description 计算结果
 * @Author fanwd
 * @Date 2019/10/25 10:24
 **/
@ApiModel("图表数据DTO")
public class DesignChartDataDTO extends DesignChartDTO {

    @ApiModelProperty(value = "计算类型0：前端计算；1：后端计算")
    private Integer type;

    @ApiModelProperty(value = "计算结果", notes = "type字段为1时此字段为结果")
    private Object result;

    public DesignChartDataDTO() {
    }

    public DesignChartDataDTO(DesignChartDTO designChartDTO, Integer type, Object result) {
        super(designChartDTO);
        this.type = type;
        this.result = result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DesignChartDataDTO{" +
                "type=" + type +
                ", result=" + result +
                '}';
    }
}
