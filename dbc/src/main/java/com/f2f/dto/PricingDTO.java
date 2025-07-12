package com.f2f.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PricingDTO {

    private Long productItemId;
    private boolean isDefault;
    private Long personId; // فقط ID
    private String pricingTypeName;
    private LocalDateTime fromDate;
    private LocalDateTime throughDate;
    private int productCount;
    private long priceAmount;
    private String currencyCode;
}
