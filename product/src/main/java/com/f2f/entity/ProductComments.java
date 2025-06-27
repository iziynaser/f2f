package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table( name = "PRODUCT_COMMENTS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"PRODUCT_ID", "COMMENT_ID"}))
public class ProductComments extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "COMMENT_ID")
    private Long commentId;


}
