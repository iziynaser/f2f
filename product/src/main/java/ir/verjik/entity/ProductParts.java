package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="PRODUCT_PARTS")
public class ProductParts extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

}
