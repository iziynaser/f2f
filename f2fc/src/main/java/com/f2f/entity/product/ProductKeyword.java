package com.f2f.entity.product;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_KEYWORD")
public class ProductKeyword extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KEY_NAME")
    private String keyName ;

    @Column(name = "KEY_WEIGHT")
    private String keyWeight;

    @Column(name = "KEY_STATUS")
    private String keyStatus;

    @ManyToMany(mappedBy = "keywords")
    private Set<Product> products = new HashSet<Product>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyWeight() {
        return keyWeight;
    }

    public void setKeyWeight(String keyWeight) {
        this.keyWeight = keyWeight;
    }

    public String getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(String keyStatus) {
        this.keyStatus = keyStatus;
    }
}
