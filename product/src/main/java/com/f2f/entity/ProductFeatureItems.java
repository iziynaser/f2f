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
    name = "PR_FEATURE_ITEMS",
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"FEATURE_ITEMS_NAME","FEATURE_ITEM_ID"})
)
public class ProductFeatureItems extends BaseEntity implements Serializable {

    @Column(name = "FEATURE_ITEMS_NAME")
    private String name;

    @Column(name = "FEATURE_ITEMS_VALUE")
    private String featureValue;

    @Column(name = "ORDERS")
    private int orders;

    @ManyToOne
    @JoinColumn(name="FEATURE_ITEM_ID")
    private ProductFeatureItem featureItem;

}
