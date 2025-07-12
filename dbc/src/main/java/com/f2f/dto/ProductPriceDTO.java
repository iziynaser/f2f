package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductPriceDTO implements Serializable {

    private String fromDate ;

    private String toDate ;

    private String currency ;

    private int tax;

    private String price;

    private Long productPriceType;

    private Long product;

}
