package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
