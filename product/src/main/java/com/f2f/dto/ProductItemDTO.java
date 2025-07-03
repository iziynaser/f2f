package com.f2f.dto;

import com.f2f.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItemDTO {

    private long id;

    private Product product;

    private Brand brand;

    private ProductColor color;

    private ProductSize size;

    private Long defaultPrice;

    private Integer salesCount;

    private Integer remainingCount ;

    private boolean available;

    private ProductPrice productPrice;

}
