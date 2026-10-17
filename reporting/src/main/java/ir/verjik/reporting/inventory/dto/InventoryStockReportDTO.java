package ir.verjik.reporting.inventory.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InventoryStockReportDTO {
    private Long productItemId;
    private String productName;
    private Long warehouseId;
    private String warehouseName;
    private Integer stockQuantity;
    private Integer reservedQuantity;
    private Integer availableQuantity;
}
