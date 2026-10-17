package ir.verjik.reporting.inventory.dto;

import lombok.Data;

@Data
public class InventoryReportDTO {
    private Long productItemId;
    private String productItemName;
    private Integer totalStock;
    private Integer availableStock;
    private String warehouseName;
}
