package com.f2f.entity.common;

import com.f2f.persistence.entity.BaseEntity;
import java.io.Serializable;

public class Productss extends BaseEntity implements Serializable{
    private String description;
    private Double price;

    public Productss() {
    }

    public Productss(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
