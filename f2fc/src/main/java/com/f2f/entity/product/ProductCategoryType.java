package com.f2f.entity.product;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_CATEGORY_TYPE")
public class ProductCategoryType extends BaseEntity {

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
