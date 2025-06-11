package com.f2f.entity.shopping;

import com.f2f.entity.PersonEntity;
import com.f2f.entity.product.Product;
import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRICING")
public class Pricing extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity personId ;

    @Column(name = "pricing_type_id")
    private PricingType pricingType;

    @Column(name = "from_date")
    private String fromDate ;

    @Column(name = "through_date")
    private String throughDate ;

    @Column(name = "product_count")
    private int productCount ;

    @Column(name = "price_amount")
    private long priceAmount ;

    @Column(name = "geo_location")
    private String geo_location;
}
