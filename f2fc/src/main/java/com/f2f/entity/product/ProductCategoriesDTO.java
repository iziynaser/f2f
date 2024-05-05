package com.f2f.entity.product;

import java.io.Serializable;

public class ProductCategoriesDTO {

//    String getProductId();
//    Long getCategoryId();
//    String getFromDate() ;
//    String getToDate() ;
//    String getDescription() ;
//    String getProductName() ;
//    String getCategoryName() ;

    private Long productId ;
    private String productName ;
    private String fromDate ;
    private String toDate ;
    private String description ;
    private Long categoryId ;
    private String categoryName ;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategoriesDTO() {
    }
}
