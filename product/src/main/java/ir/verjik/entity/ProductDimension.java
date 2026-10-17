package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;

 
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
