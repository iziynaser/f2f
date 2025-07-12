package com.f2f.service;

import com.f2f.dto.Context;
import com.f2f.dto.FinalPriceDTO;
import com.f2f.dto.PricingDTO;
import com.f2f.entity.DiscountRule;
import com.f2f.port.DiscountPort;
import com.f2f.port.InventoryPort;
import com.f2f.port.PricingPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceCalculatorService {

    private final PricingPort pricingPort;
    private final DiscountPort discountPort;
    private final InventoryPort inventoryPort;
    private final DiscountEngine discountEngine;

    public PriceCalculatorService(PricingPort pricingPort,
                                  DiscountPort discountPort,
                                  InventoryPort inventoryPort,
                                  DiscountEngine discountEngine) {
        this.pricingPort = pricingPort;
        this.discountPort = discountPort;
        this.inventoryPort = inventoryPort;
        this.discountEngine = discountEngine;
    }

    public FinalPriceDTO calculateFinalPrice(Long productItemId, Long personId, Integer quantity, String geoLocation) {
        LocalDateTime now = LocalDateTime.now();

        PricingDTO activePrice = pricingPort.findActivePricing(productItemId, personId, now);
        long basePrice = (activePrice != null) ? activePrice.getPriceAmount() : 0;

        Context context = new Context();
        context.setProductItemId(productItemId);
        context.setPersonId(personId);
        context.setQuantity(quantity != null && quantity > 0 ? quantity : 1);
        context.setGeoLocation(geoLocation);
        context.setRequestDate(now.toLocalDate());

        // در صورت نیاز مقدار brandId و categoryId را از دیتابیس بگیری و ست کن

        List<DiscountRule> applicableRules = discountEngine.findApplicableRules(context);
        DiscountRule bestRule = discountEngine.selectBestDiscount(applicableRules);
        long discountedPrice = discountEngine.applyDiscount(basePrice, bestRule);

        Integer inventoryCount = inventoryPort.sumAvailableInventory(productItemId);

        FinalPriceDTO dto = new FinalPriceDTO();
        dto.setBasePrice(basePrice);
        dto.setFinalPrice(discountedPrice);
        dto.setDiscountName(bestRule != null ? bestRule.getName() : null);
        dto.setDiscountType(bestRule != null ? bestRule.getDiscountType() : null);
        dto.setDiscountValue(bestRule != null ? bestRule.getDiscountValue() : null);
        dto.setHasLowStock(inventoryCount != null && inventoryCount < 5);
        dto.setStockQuantity(inventoryCount != null ? inventoryCount : 0);

        return dto;
    }
}
