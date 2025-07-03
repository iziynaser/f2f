package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice extends BaseEntity {

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "currency")
    private String currency ;

    @Column(name = "tax")
    private int tax;

    @Column(name = "PRICE")
    private String value;

    @OneToOne
    @JoinColumn(name = "PRODUCT_PRICE_TYPE_ID")
    private ProductPriceType productPriceType;

//    @ManyToOne
//    private Product product;

}
