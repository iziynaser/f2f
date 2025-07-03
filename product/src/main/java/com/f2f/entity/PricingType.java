package com.f2f.entity.shopping;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
