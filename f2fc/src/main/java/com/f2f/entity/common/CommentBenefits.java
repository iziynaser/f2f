package com.f2f.entity.common;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COMMENT_BENEFITS")
public class CommentBenefits extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment ;

    private String name;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommentBenefits(){}
    public CommentBenefits(Comment comment, String name) {
        this.comment = comment;
        this.name = name;
    }
}
