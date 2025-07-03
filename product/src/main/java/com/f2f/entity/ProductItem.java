package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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

    @Column(name = "remainCount")
    private Integer remainingCount ;

    private boolean available;

    @ManyToOne
    private ProductPrice productPrice;

    public ProductItem(Long productItemId) {
        super();
    }

//    @OneToMany(mappedBy = "productItem",cascade = CascadeType.ALL)
//    private List<StockBatches> stockBatches;

}
