package com.f2f.entity.shopping;

import com.f2f.entity.product.Product;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRICING")
public class Pricing extends BaseEntity {

    private Product productId;

    //private PricingType pricingType;

    private String fromDate ;

    private String throughDate ;


}
