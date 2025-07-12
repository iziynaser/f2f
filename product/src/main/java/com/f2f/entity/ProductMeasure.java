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

    private float width;//عرض

    @OneToOne
    @JoinColumn(name = "WIDTH_MEASURE_ID")
    private MeasureUnit widthType;//نوع عرض

    private float height ;//ارتفاع

    @OneToOne
    @JoinColumn(name = "HEIGHT_MEASURE_ID")
    private MeasureUnit heightType;//نوع ارتفاع

    private float weight ;// وزن

    @OneToOne
    @JoinColumn(name = "WEIGHT_MEASURE_ID")
    private MeasureUnit weightType;//نوع وزن

    private float depth ;//عمق

    @OneToOne
    @JoinColumn(name = "DEPTH_MEASURE_ID")
    private MeasureUnit depthType;//نوع عمق

}
