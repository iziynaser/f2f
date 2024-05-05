package com.f2f.entity.product;

import com.f2f.entity.common.Category;
//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "BRAND")
public class Brand extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    private Category categoryId;

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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
