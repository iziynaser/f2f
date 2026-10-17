package ir.verjik.reporting.sales.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSalesReportDTO {
    private Long productItemId;
    private String productName;
    private Long totalQuantitySold;
    private BigDecimal totalSalesAmount;
    private Long totalOrders;
}
