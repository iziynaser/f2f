package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingRequestDTO {
    private long basePrice;
    private DiscountContext context;
}
