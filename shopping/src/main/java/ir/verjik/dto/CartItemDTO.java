package ir.verjik.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long itemId;
    private Long productItemId;
    private String productName;
    private Integer quantity;
    private Long unitPrice;
    private Long totalPrice;
}
