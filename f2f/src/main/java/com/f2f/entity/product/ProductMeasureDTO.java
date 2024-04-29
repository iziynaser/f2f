package com.f2f.entity.product;

import java.io.Serializable;

public class ProductMeasureDTO implements Serializable {

    private Long product;
    private float width;
    private Long widthType;
    private float height ;
    private Long heightType;
    private float weight ;
    private Long weightType;
    private float depth ;
    private Long depthType;

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Long getWidthType() {
        return widthType;
    }

    public void setWidthType(Long widthType) {
        this.widthType = widthType;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Long getHeightType() {
        return heightType;
    }

    public void setHeightType(Long heightType) {
        this.heightType = heightType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Long getWeightType() {
        return weightType;
    }

    public void setWeightType(Long weightType) {
        this.weightType = weightType;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public Long getDepthType() {
        return depthType;
    }

    public void setDepthType(Long depthType) {
        this.depthType = depthType;
    }
}
