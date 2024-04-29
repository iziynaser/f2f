package com.f2f.entity.product;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;

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
