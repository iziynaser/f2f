package com.f2f.entity.product;

import java.io.Serializable;

public class ProductPriceDTO implements Serializable {

    private String fromDate ;

    private String toDate ;

    private int currency ;

    private int tax;

    private String price;

    private Long productPriceType;

    private Long product;

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

    public Long getProductPriceType() {
        return productPriceType;
    }

    public void setProductPriceType(Long productPriceType) {
        this.productPriceType = productPriceType;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
