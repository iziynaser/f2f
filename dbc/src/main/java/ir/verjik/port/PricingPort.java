package ir.verjik.port;

import ir.verjik.dto.PricingDTO;

import java.time.LocalDateTime;

public interface PricingPort {
    PricingDTO findActivePricing(Long productItemId, Long personId, LocalDateTime dateTime);
}