package com.f2f.port;

import com.f2f.dto.PricingDTO;

import java.time.LocalDateTime;

public interface PricingPort {
    PricingDTO findActivePricing(Long productItemId, Long personId, LocalDateTime dateTime);
}