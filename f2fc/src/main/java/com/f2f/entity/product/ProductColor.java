package com.f2f.entity.product;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_COLOR")
public class ProductColor extends BaseEntity implements Serializable {

    @Column(name = "COLOR_NAME")
    private String name ;

    @Column(name = "COLOR_VALUE")
    private String value ;

    @ManyToOne
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
