package com.f2f.entity.product;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
//import com.f2f.persistance.entity.BaseEntity;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "PR_FEATURE_ITEMS",
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"FEATURE_ITEMS_NAME","FEATURE_ITEM_ID"})
)
public class ProductFeatureItems extends BaseEntity implements Serializable {

    //@Column(name = "name",unique = true)
    @Column(name = "FEATURE_ITEMS_NAME")
    private String name;

    @Column(name = "FEATURE_ITEMS_VALUE")
    private String featureValue;

    @Column(name = "ORDERS")
    private int orders;

    @ManyToOne
    @JoinColumn(name="FEATURE_ITEM_ID")
    private ProductFeatureItem featureItem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrders() {
        return orders;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public ProductFeatureItem getFeatureItem() {
        return featureItem;
    }

    public void setFeatureItem(ProductFeatureItem featureItem) {
        this.featureItem = featureItem;
    }
}
