package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
    name = "PR_FEATURE_ITEM",
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"FEATURE_ITEM_NAME","FEATURE_GROUP_ID"})
)
public class ProductFeatureItem extends BaseEntity implements Serializable {

    @Column(name = "FEATURE_ITEM_NAME",nullable = false)
    private String name;

    @Column(name = "FEATURE_ITEM_VALUE")
    private String featureValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FEATURE_GROUP_ID")
    private ProductFeatureGroup featureGroup;

    @OneToMany(mappedBy = "featureItem",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductFeatureValue> featureItems=new ArrayList<>();

    @Column(name = "ORDERS")
    private Integer orders;

}
