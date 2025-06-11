package com.f2f.entity.product;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "currency")
    private String currency ;

    @Column(name = "tax")
    private int tax;

    @Column(name = "PRICE")
    private String value;

    @OneToOne
    @JoinColumn(name = "PRODUCT_PRICE_TYPE_ID")
    private ProductPriceType productPriceType;

//    @ManyToOne
//    private Product product;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProductPriceType getProductPriceType() {
        return productPriceType;
    }

    public void setProductPriceType(ProductPriceType productPriceType) {
        this.productPriceType = productPriceType;
    }
}
