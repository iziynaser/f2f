package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private  Integer categoryId;

    @Column(name = "product_type_id", insertable=false , updatable=false)
    private Integer productTypeId;// masrafi,faallah,packaging

    @Column(name = "divisible")
    private Boolean divisible;

    @Column(name = "INTERNAL_NAME")
    private String internalName;

    @Column(name = "NAME")
    private String name;

    private Long commentTargetId;

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
}
