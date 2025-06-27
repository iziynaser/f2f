package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

 
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="PRODUCT_DIMMENSION")
public class ProductDimension extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

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
