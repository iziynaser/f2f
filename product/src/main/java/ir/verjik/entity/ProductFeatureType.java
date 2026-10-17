package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_FEATURE_TYPE")
public class ProductFeatureType extends BaseEntity {

    /**
     * HARD_FEATURE
     * SOFT_FEATURE
     * OPTIONAL_FEATURE
     * STANDARD_FEATURE
     * ADDITIONAL
     */

    @Column(name = "NAME",unique = true,nullable = false)
    private String name ;

    @Column(name = "VALUE")
    private String value;

}
