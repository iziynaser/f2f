package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_ITEM")
public class ProductItem  extends BaseEntity implements Serializable {

    @Column(name ="product_item_code")
    private String productItemCode ;

    @ManyToOne
    private Product product;

   @ManyToOne
    private Brand brand;

   @ManyToOne
    private ProductColor color;

   @ManyToOne
   private ProductSize size;

    @Column(name = "price")
    private Long defaultPrice;

    @Column(name = "salesCount")
    private Integer salesCount;

    public ProductItem(Long productItemId) {
        super();
    }

    public ProductItem() {
        super();
    }

}
