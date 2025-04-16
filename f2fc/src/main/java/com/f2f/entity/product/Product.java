package com.f2f.entity.product;

import com.f2f.entity.common.CommentTarget;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_dimension")
    private String productDimension;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "category_id")
    private  int categoryId;

    @Column(name = "product_type_id", insertable=false , updatable=false)
    private int productTypeId;

    @Column(name = "INTERNAL_NAME")
    private String internalName;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "COMMENT_TARGET_ID")
    private CommentTarget commentTarget;

    @OneToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    private ProductType productType;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name="IS_VIRTUAL")
    private String isVirtual;

    @Column(name = "INTRO_DATE")
    private String introDate;

    @Column(name = "RELEASE_DATE")
    private String releaseDate ;

    @Column(name = "DISCONTINUED_DATE")
    private String disContinuedDate;

    @Column(name = "BRAND")
    private String brand;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getIntroDate() {
        return introDate;
    }

    public void setIntroDate(String introDate) {
        this.introDate = introDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDisContinuedDate() {
        return disContinuedDate;
    }

    public void setDisContinuedDate(String disContinuedDate) {
        this.disContinuedDate = disContinuedDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CommentTarget getCommentTarget() {
        return commentTarget;
    }

    public void setCommentTarget(CommentTarget commentTarget) {
        this.commentTarget = commentTarget;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getProductDimension() {
        return productDimension;
    }

    public void setProductDimension(String productDimension) {
        this.productDimension = productDimension;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }
}
