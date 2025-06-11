package com.f2f.entity.product;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_FEATURE_TYPE")
public class ProductFeatureType extends BaseEntity {

    /**
     * HARD_FEATURE
     * SOFT_FEATURE
     * OPTIONAL_FEATURE
     * STANDARD_FEATURE
     * ADDITIONAL
     */

    @Column(name = "NAME")
    private String name ;

    @Column(name = "VALUE")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
