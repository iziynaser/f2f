package com.f2f.entity.product;


<<<<<<< Updated upstream:src/main/java/com/f2f/entity/product/ProductPrice.java

import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
=======
import com.f2f.persistance.entity.BaseEntity;
>>>>>>> Stashed changes:f2f/src/main/java/com/f2f/entity/product/ProductPrice.java

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice extends BaseEntity {

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "currency")
    private int currency ;

    @Column(name = "tax")
    private int tax;

    @Column(name = "PRICE")
    private String price;

    @OneToOne
    @JoinColumn(name = "PRODUCT_PRICE_TYPE_ID")
    private ProductPriceType productPriceType;

    @ManyToOne
    private Product product;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductPriceType getProductPriceType() {
        return productPriceType;
    }

    public void setProductPriceType(ProductPriceType productPriceType) {
        this.productPriceType = productPriceType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
