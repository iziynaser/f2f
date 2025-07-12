package com.f2f.port;

import com.f2f.dto.Context;
import com.f2f.dto.DiscountContext;
import com.f2f.dto.PriceCalculationResult;

public interface PriceCalculationPort {
    PriceCalculationResult calculateFinalPriceWithDetail(long basePrice, Context context);
}
