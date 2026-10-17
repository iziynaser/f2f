package ir.verjik.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockInRequest {
    private Long productId;
    private Long warehouseId;
    private int quantity;
    private BigDecimal purchasePrice;
    private String referenceNumber;
}
