package com.f2f.entity.product;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PRODUCT_DIMMENSION")
public class ProductDimension extends BaseEntity implements Serializable {

    @Column(name = "WIDTH")
    private String width ;

    @Column(name = "HEIGHT")
    private String height;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
