package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRICING")
public class Pricing extends BaseEntity {

//    @OneToOne
//    @JoinColumn(name = "product_id")
    private Long productItemId;

    /*
    مشخص می کند ایا قیمت پیش فرض است یا نه
     */
    private boolean isdefault ;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity personId ;

    @ManyToOne
    @JoinColumn(name = "pricing_type_id")
    private PricingType pricingType;

    @Column(name = "from_date")
    private LocalDateTime fromDate ;

    @Column(name = "through_date")
    private LocalDateTime throughDate ;

    @Column(name = "product_count")
    private int productCount ;

    @Column(name = "price_amount")
    private long priceAmount ;

    @Column(name = "geo_location")
    private String geo_location;

    @ManyToOne
    private Currency currency;

}
