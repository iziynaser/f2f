package com.f2f.dto;

import com.f2f.enums.DiscountType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
}