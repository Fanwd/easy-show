package com.glodon.easyshow.js;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName Project
 * @Description TODO
 * @Author fanwd
 * @Date 2019/10/18 23:15
 **/
@ApiModel("项目信息")
public class Project {

    @ApiModelProperty("项目ID")
    private Long id;
    @ApiModelProperty("项目名称")
    private String name;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("计划产值")
    private Double planValue;
    @ApiModelProperty("实际产值")
    private Double realValue;
    @ApiModelProperty("合同额")
    private Double constructValue;
    @ApiModelProperty("项目状态")
    private String status;

    public Project() {
    }

    public Project(Long id, String name, String province, String city, Double planValue, Double realValue, Double constructValue, String status) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.city = city;
        this.planValue = planValue;
        this.realValue = realValue;
        this.constructValue = constructValue;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPlanValue() {
        return planValue;
    }

    public void setPlanValue(Double planValue) {
        this.planValue = planValue;
    }

    public Double getRealValue() {
        return realValue;
    }

    public void setRealValue(Double realValue) {
        this.realValue = realValue;
    }

    public Double getConstructValue() {
        return constructValue;
    }

    public void setConstructValue(Double constructValue) {
        this.constructValue = constructValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
