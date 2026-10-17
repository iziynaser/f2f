package ir.verjik.dto;

import lombok.Data;

@Data
public class AddToCartRequest {
    private Long productItemId;
    private Integer quantity;
}

