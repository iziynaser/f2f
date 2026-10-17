package ir.verjik.dto;

import lombok.Data;

@Data
public class StockOutRequest {
    private Long productId;
    private Long warehouseId;
    private int quantity;
    private String reason;
    private String receiverName ;
}
