package ir.verjik.dto;

import ir.verjik.enums.DiscountType;
import lombok.Data;

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
