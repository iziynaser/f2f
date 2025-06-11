package com.f2f.entity.product;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_ITEM")
public class ProductItem  extends BaseEntity implements Serializable {

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductColor getColor() {
        return color;
    }

    public void setColor(ProductColor color) {
        this.color = color;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

    public Long getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Long defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public Integer getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(Integer remainingCount) {
        this.remainingCount = remainingCount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }
}
