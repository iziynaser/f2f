package ir.verjik.dto;

import ir.verjik.dbc.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItemDTO {

    private long id;

    private ProductDTO product;

    private BrandDTO brand;

    private ProductColorDTO color;

    private ProductSizeDTO size;

    private Long defaultPrice;

    private Long finalPrice;
    private boolean hasLowStock;
    private int stockQuantity;
    private Long discountValue;

    private Integer salesCount;

    private Integer remainingCount ;

    private boolean available;

    private ProductPriceDTO productPrice;

}
