package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_COLOR")
public class ProductColor extends BaseEntity implements Serializable {

    @Column(name = "COLOR_NAME")
    private String name ;

    @Column(name = "COLOR_VALUE")
    private String value ;

}
