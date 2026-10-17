package ir.verjik.dto;

import lombok.Data;

@Data
public class InventoryDTO {
    private Long productId;
    private String name;
    private int quantity ;
}
