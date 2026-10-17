package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricingRequestDTO {
    private long basePrice;
    private DiscountContext context;
}
