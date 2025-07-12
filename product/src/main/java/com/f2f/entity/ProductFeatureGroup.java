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
@Table(name = "PR_FEATURE_GROUP")
public class ProductFeatureGroup extends BaseEntity implements Serializable {

    @Column(name = "FEATURE_GROUP_NAME")
    private String name;

    @Column(name = "FEATURE_GROUP_VALUE")
    private String featureValue;

    @OneToOne
    private Product product;

    @Column(name = "ORDERS")
    private Integer orders;

    @OneToMany(mappedBy = "featureGroup")
    private List<ProductFeatureItem> features;

    public ProductFeatureGroup() {
    }

    public ProductFeatureGroup(String name, String value, int orders) {
        this.name = name;
        this.featureValue = value;
        this.orders = orders;
    }
}
