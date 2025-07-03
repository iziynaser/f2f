package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_KEYWORD")
public class ProductKeyword extends BaseEntity implements Serializable {

    @Column(name = "KEY_NAME")
    private String keyName ;

    @Column(name = "KEY_WEIGHT")
    private String keyWeight;

    @Column(name = "KEY_STATUS")
    private String keyStatus;

    @ManyToMany(mappedBy = "keywords")
    private Set<Product> products = new HashSet<Product>();

}
