package ir.verjik.strategy;

import ir.verjik.dto.Context;
import ir.verjik.entity.Discount;

public interface DiscountStrategy {
    boolean isApplicable(Discount discount,Context context);
    long applyDiscount(Discount discount, Context context);
}
