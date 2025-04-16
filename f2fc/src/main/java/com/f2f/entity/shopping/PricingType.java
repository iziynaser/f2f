package com.f2f.entity.shopping;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PRICING_TYPE")
public class PricingType extends BaseEntity {

    @Column(name = "price_type_id")
    private int pricingTypeId ;

    @Column(name = "name")
    private String priceTypeName;

    @Column(name = "description")
    private String priceTypeDescription ;
}
