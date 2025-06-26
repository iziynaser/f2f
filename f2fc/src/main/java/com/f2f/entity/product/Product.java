package com.f2f.entity.product;

import com.f2f.entity.common.CommentTarget;
import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductItem> items = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "product_keywords",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private Set<ProductKeyword> keywords = new HashSet<>();

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

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductImage> images;


    //bl
    public Long getMinPrice(){
        if(items==null || items.isEmpty()){
            return null;
        }
        return items.stream()
                .filter(item -> item.getDefaultPrice() !=null)
                .mapToLong(ProductItem::getDefaultPrice)
                .min()
                .orElse(0);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Set<ProductItem> getItems() {
        return items;
    }

    public void setItems(Set<ProductItem> items) {
        this.items = items;
    }

    public Set<ProductKeyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<ProductKeyword> keywords) {
        this.keywords = keywords;
    }

    public String getProductDimension() {
        return productDimension;
    }

    public void setProductDimension(String productDimension) {
        this.productDimension = productDimension;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public CommentTarget getCommentTarget() {
        return commentTarget;
    }

    public void setCommentTarget(CommentTarget commentTarget) {
        this.commentTarget = commentTarget;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductImage> getImages() {
        return images;
    }

    public void setImages(Set<ProductImage> images) {
        this.images = images;
    }
}
