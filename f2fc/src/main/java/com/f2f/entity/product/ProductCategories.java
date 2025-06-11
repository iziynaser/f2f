package com.f2f.entity.product;

import com.f2f.entity.common.Category;
import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "PRODUCT_CATEGORIES" ,
        uniqueConstraints = @UniqueConstraint(columnNames = {"PRODUCT_ID", "CATEGORY_ID"})
      )
public class ProductCategories extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category ;

    @Column(name = "FROM_DATE")
    private String fromDate ;

    @Column(name = "TO_DATE")
    private String toDate;

    @Column(name = "DESCRIPTION")
    private String description;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
