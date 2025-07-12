package com.f2f.dto;

import com.f2f.enums.DiscountType;
import com.f2f.enums.DiscountApplyLevel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountDTO {

    private DiscountType discountType;
    private String discountName;
    private Long discountValue;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    private Long productItemId;
    private Long personId;
    private Long categoryId;
    private Long brandId;

    private int minQuantity;
    private int maxQuantity;

    private Long minTotalAmount;
    private Long maxTotalAmount;

    private String origin;
    private DiscountApplyLevel applyTo;

    private int usageLimit;
}
