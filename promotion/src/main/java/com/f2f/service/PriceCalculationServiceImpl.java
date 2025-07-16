package com.f2f.service;

import com.f2f.dto.Context;
import com.f2f.dto.PriceCalculationResult;
import com.f2f.entity.DiscountRule;
import com.f2f.enums.DiscountType;
import com.f2f.port.PriceCalculationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceCalculationServiceImpl implements PriceCalculationPort {

    private final DiscountEngine discountEngine;

    @Override
    public PriceCalculationResult calculateFinalPriceWithDetail(long basePrice, Context context) {
        List<DiscountRule> applicableRules = discountEngine.findApplicableRules(context);

        // تخفیف‌های مالی (قابل اعمال بر قیمت)
        List<DiscountRule> financialRules = applicableRules.stream()
                .filter(rule -> rule.getDiscountType() == DiscountType.PERCENTAGE
                        || rule.getDiscountType() == DiscountType.FIXED)
                .toList();

        // تخفیف‌های غیرمالی (ارسال رایگان، هدیه و ...)
        List<DiscountRule> nonFinancialRules = applicableRules.stream()
                .filter(rule -> rule.getDiscountType() != DiscountType.PERCENTAGE
                        && rule.getDiscountType() != DiscountType.FIXED)
                .toList();

        // انتخاب بهترین تخفیف مالی
        DiscountRule bestFinancialRule = discountEngine.selectBestDiscount(financialRules);
        long finalPrice = discountEngine.applyDiscount(basePrice, bestFinancialRule);

        // ساخت خروجی
        PriceCalculationResult result = new PriceCalculationResult();
        result.setBasePrice(basePrice);
        result.setFinalPrice(finalPrice);
        result.setDiscountValue(bestFinancialRule != null ? bestFinancialRule.getDiscountValue() : null);
        result.setDiscountType(bestFinancialRule != null ? bestFinancialRule.getDiscountType() : null);
        result.setAppliedRuleName(bestFinancialRule != null ? bestFinancialRule.getName() : null);

        // اضافه‌کردن لیست تخفیف‌های غیرمالی
        List<String> nonFinancialDescriptions = new ArrayList<>();
        for (DiscountRule nf : nonFinancialRules) {
            nonFinancialDescriptions.add(nf.getName());
        }
        result.setNonFinancialDiscounts(nonFinancialDescriptions);

        return result;
    }
}
