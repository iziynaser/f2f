package ir.verjik.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemCreateDTO {
    private Long productItemId;
    private Integer quantity;
}
