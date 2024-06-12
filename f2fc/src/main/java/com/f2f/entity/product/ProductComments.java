package com.f2f.entity.product;

import com.f2f.entity.common.Comment;
import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "PRODUCT_COMMENTS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"PRODUCT_ID", "COMMENT_ID"}))
public class ProductComments extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
