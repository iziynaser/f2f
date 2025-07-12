package com.f2f.strategy;

import com.f2f.dto.Context;
import com.f2f.entity.Discount;

public interface DiscountStrategy {
    boolean isApplicable(Discount discount,Context context);
    long applyDiscount(Discount discount, Context context);
}
