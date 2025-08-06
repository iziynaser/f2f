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
    name = "PR_FEATURE_VALUE",
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"FEATURE_ITEMS_NAME","FEATURE_ITEM_ID"})
)
public class ProductFeatureValue extends BaseEntity implements Serializable {

    @Column(name = "FEATURE_ITEMS_NAME",nullable = false)
    private String name;

    @Column(name = "FEATURE_ITEMS_VALUE",nullable = false)
    private String featureValue;

    @Column(name = "ORDERS")
    private Integer orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FEATURE_ITEM_ID")
    private ProductFeatureItem featureItem;

}
