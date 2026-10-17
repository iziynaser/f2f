package ir.verjik.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartResponse {
    private Long cartId;
    private List<CartItemDTO> items;
    private String status;
}

