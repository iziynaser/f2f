package com.f2f.entity.product;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PR_FEATURE_GROUP")
public class ProductFeatureGroup extends BaseEntity implements Serializable {

    @Column(name = "FEATURE_GROUP_NAME")
    private String name;

    @Column(name = "FEATURE_GROUP_VALUE")
    private String featureValue;

    //@Column(name = "PRODUCT_ID")
    @OneToOne
    private Product product;

    @Column(name = "ORDERS")
    private int orders;

    @OneToMany(mappedBy = "featureGroup")
    private List<ProductFeatureItem> features;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductFeatureItem> getFeatures() {
        return features;
    }

    public void setFeatures(List<ProductFeatureItem> features) {
        this.features = features;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public ProductFeatureGroup() {
    }

    public ProductFeatureGroup(String name, String value, int orders) {
        this.name = name;
        this.featureValue = value;
        this.orders = orders;
    }
}
