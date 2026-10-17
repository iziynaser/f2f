package ir.verjik.port;

import ir.verjik.dto.Context;
import ir.verjik.dto.PriceCalculationResult;

public interface PriceCalculationPort {
    PriceCalculationResult calculateFinalPriceWithDetail(long basePrice, Context context);
}
