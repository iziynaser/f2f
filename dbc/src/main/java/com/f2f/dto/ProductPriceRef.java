package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductPriceRef implements Serializable {

    private boolean isAvailable;
    private Long defaultPrice ;
    private boolean hasDiscount;
    private Long discountAmount;
    private Long finalPrice;
    private Integer remainingQuantityIfLow;

}
