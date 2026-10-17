package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceResponseDTO {
    private Long productItemId;
    private long basePrice;
    private Long discountAmount;
    private long finalPrice;
    private String appliedRuleName; // (اختیاری)
}
