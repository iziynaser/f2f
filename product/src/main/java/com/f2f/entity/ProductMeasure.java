package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUCT_FEATURE")
public class ProductMeasure extends BaseEntity {

    @OneToOne
    @JoinColumn(name ="PRODUCT_ID")
    private Product product;

    private float width;

    @OneToOne
    @JoinColumn(name = "WIDTH_MEASURE_ID")
    private MeasureUnit widthType;

    private float height ;

    @OneToOne
    @JoinColumn(name = "HEIGHT_MEASURE_ID")
    private MeasureUnit heightType;

    private float weight ;

    @OneToOne
    @JoinColumn(name = "WEIGHT_MEASURE_ID")
    private MeasureUnit weightType;

    private float depth ;

    @OneToOne
    @JoinColumn(name = "DEPTH_MEASURE_ID")
    private MeasureUnit depthType;

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public MeasureUnit getWidthType() {
        return widthType;
    }

    public void setWidthType(MeasureUnit widthType) {
        this.widthType = widthType;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public MeasureUnit getHeightType() {
        return heightType;
    }

    public void setHeightType(MeasureUnit heightType) {
        this.heightType = heightType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public MeasureUnit getWeightType() {
        return weightType;
    }

    public void setWeightType(MeasureUnit weightType) {
        this.weightType = weightType;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public MeasureUnit getDepthType() {
        return depthType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDepthType(MeasureUnit depthType) {
        this.depthType = depthType;
    }
}
