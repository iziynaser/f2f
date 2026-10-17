package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_CATEGORY_TYPE")
public class ProductCategoryType extends BaseEntity {

    @Column(name = "NAME")
    private String name ;

    @Column(name = "VALUE")
    private String value;

}
