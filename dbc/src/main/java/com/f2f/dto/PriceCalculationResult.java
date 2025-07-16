package com.f2f.dto;

import com.f2f.enums.DiscountType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class PriceCalculationResult {

    private long basePrice;
    private long finalPrice;
    private Long discountValue;
    private DiscountType discountType;
    private String appliedRuleName;
    private List<String> nonFinancialDiscounts; // 👈 جدید

}
