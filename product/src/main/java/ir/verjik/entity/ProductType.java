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
@Table(name = "PRODUCT_TYPE")
public class ProductType extends BaseEntity implements Serializable {

    @Column(name = "product_type_id")
    private Long productTypeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "DESCRIPTION")
    private String description ;

    @Column(name = "ORDERS")
    private Integer orders;

}
