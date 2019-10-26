package com.glodon.easyshow.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName TransInfo
 * @Description 交易信息
 * @Author fanwd
 * @Date 2019/10/25 22:46
 **/
@ApiModel("电脑信息")
public class ComputerInfo {

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 型号
     */
    @ApiModelProperty("型号")
    private String model;
    /**
     * 品牌
     */
    @ApiModelProperty("品牌")
    private String brand;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;
    /**
     * 成本
     */
    @ApiModelProperty("成本")
    private Double cost;
    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private Double price;
    /**
     * 个数
     */
    @ApiModelProperty("个数")
    private Integer count;

    public ComputerInfo() {
    }

    public ComputerInfo(String id, String model, String brand, String type, Double cost, Double price, Integer count) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.cost = cost;
        this.price = price;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ComputerInfo{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
