package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


import java.io.Serializable;

@Entity
@Table(name="PRODUCT_PARTS")
public class ProductParts extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
