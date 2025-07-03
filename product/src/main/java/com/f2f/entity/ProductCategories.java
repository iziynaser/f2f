package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(
        name = "PRODUCT_CATEGORIES" ,
        uniqueConstraints = @UniqueConstraint(columnNames = {"PRODUCT_ID", "CATEGORY_ID"})
      )
public class ProductCategories extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category ;

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate;

    @Column(name = "DESCRIPTION")
    private String description;

}
