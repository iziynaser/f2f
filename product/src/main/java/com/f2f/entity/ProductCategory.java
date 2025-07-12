package com.f2f.entity;
import jakarta.persistence.*;

import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

    @ManyToOne
    @JoinColumn(name = "PARENT_PRODUCT_CATEGORY_ID")
    private ProductCategory parentProductCategory;

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate;

    public ProductCategory() {
    }

    public ProductCategory(String name, ProductCategory parentProductCategory, String fromDate, String toDate) {
        this.name = name;
        this.parentProductCategory = parentProductCategory;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        //sb.append("id :"+ id +" ,");
        sb.append("name :"+ name +" , ");
        sb.append("parentCategory :"+ parentProductCategory +" , ");

        return sb.toString();
    }

}
