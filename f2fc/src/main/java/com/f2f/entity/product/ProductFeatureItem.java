package com.f2f.entity.product;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
    name = "PR_FEATURE_ITEM",
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"FEATURE_ITEM_NAME","FEATURE_GROUP_ID"})
)
public class ProductFeatureItem extends BaseEntity implements Serializable {

    //@Column(name = "FEATURE_NAME",unique = true)
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

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductFeatureGroup getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(ProductFeatureGroup featureGroup) {
        this.featureGroup = featureGroup;
    }

    public List<ProductFeatureItems> getFeatureItems() {
        return featureItems;
    }

    public void setFeatureItems(List<ProductFeatureItems> featureItems) {
        this.featureItems = featureItems;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
