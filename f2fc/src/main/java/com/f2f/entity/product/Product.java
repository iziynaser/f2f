package com.f2f.entity.product;

import com.f2f.entity.common.CommentTarget;
import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity implements Serializable {


    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "INTERNAL_NAME")
    private String internalName;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "COMMENT_TARGET_ID")
    private CommentTarget commentTarget;

//    @OneToOne
//    @JoinColumn(name = "PRODUCT_TYPE_ID")
//    private ProductType productType;

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
}
