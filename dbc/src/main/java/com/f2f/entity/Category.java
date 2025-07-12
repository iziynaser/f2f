package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.dbc.entity.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity implements Serializable {

    @Column(name = "CATEGORY_CODE")
    private String categoryCode;

    @Column(name = "NAME")
    private String name ;

    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    private Category parentCategory;

    //@Column(name = "CATEGORY_TYPE")
    @OneToOne
    @JoinColumn(name = "CATEGORY_TYPE_ID")
    private CategoryType categoryType;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "DETAIL_IMAGE_URL")
    private String detailImageUrl;

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate;

    public Category() {
    }

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }
}

