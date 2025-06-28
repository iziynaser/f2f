package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
    name = "PR_FEATURE_ITEM",
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"FEATURE_ITEM_NAME","FEATURE_GROUP_ID"})
)
public class ProductFeatureItem extends BaseEntity implements Serializable {

    @Column(name = "FEATURE_ITEM_NAME")
    private String name;

    @Column(name = "FEATURE_ITEM_VALUE")
    private String featureValue;

    @ManyToOne
    @JoinColumn(name = "FEATURE_GROUP_ID")
    private ProductFeatureGroup featureGroup;

    @OneToMany(mappedBy = "featureItem")
    private List<ProductFeatureItems> featureItems;

    @Column(name = "ORDERS")
    private Integer orders;

}
