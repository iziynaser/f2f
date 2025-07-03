package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_CATEGORY_TYPE")
public class ProductCategoryType extends BaseEntity {

    @Column(name = "NAME")
    private String name ;

    @Column(name = "VALUE")
    private String value;

}
