package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
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

   //@ManyToOne
    private Long brandId;

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
