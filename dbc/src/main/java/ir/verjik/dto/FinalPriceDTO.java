package ir.verjik.dto;

import ir.verjik.enums.DiscountType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FinalPriceDTO {
    private long basePrice;
    private long finalPrice;
    private String discountName;
    private DiscountType discountType;  // یا String اگر رشته است
    private Long discountValue;
    private boolean hasLowStock;
    private int stockQuantity;
    private LocalDate requestDate;
    private List<String> benefits;
}