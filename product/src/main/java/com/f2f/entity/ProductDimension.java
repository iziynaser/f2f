package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

 
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="PRODUCT_DIMMENSION")
public class ProductDimension extends BaseEntity implements Serializable {

    @Column(name = "WIDTH")
    private String width ;

    @Column(name = "HEIGHT")
    private String height;

}
