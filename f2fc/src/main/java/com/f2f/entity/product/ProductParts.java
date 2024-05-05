package com.f2f.entity.product;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
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
