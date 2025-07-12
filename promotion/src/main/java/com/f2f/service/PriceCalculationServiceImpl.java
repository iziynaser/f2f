package com.f2f.service;

import com.f2f.dto.Context;
import com.f2f.dto.DiscountContext;
import com.f2f.dto.PriceCalculationResult;
import com.f2f.entity.DiscountRule;
import com.f2f.port.PriceCalculationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceCalculationServiceImpl implements PriceCalculationPort {

    private final DiscountEngine discountEngine;

    @Override
    public PriceCalculationResult calculateFinalPriceWithDetail(long basePrice, Context context) {
        List<DiscountRule> rules = discountEngine.findApplicableRules(context);
        DiscountRule bestRule = discountEngine.selectBestDiscount(rules);
        long finalPrice = discountEngine.applyDiscount(basePrice, bestRule);

        PriceCalculationResult result = new PriceCalculationResult();
        result.setBasePrice(basePrice);
        result.setFinalPrice(finalPrice);
        result.setAppliedRuleName(bestRule != null ? bestRule.getName() : null);

        return result;
    }
}
