package ir.verjik.reporting.common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSalesSummaryDTO {
    private Long productItemId;
    private Long totalQuantity;
    private BigDecimal totalRevenue;

    public ProductSalesSummaryDTO(Long productItemId, Long totalQuantity, BigDecimal totalRevenue) {
        this.productItemId = productItemId;
        this.totalQuantity = totalQuantity;
        this.totalRevenue = totalRevenue;
    }
}
