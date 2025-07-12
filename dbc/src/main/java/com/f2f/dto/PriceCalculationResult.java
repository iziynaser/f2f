package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceCalculationResult {

    private long basePrice;         // قیمت اولیه قبل از تخفیف
    private long finalPrice;        // قیمت نهایی پس از اعمال تخفیف
    private String appliedRuleName; // نام قانون تخفیف (در صورت وجود)
}
