package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMMENT_TARGET")
public class CommentTarget extends BaseEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "commentTarget")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public CommentTarget(){

    }

    public CommentTarget(List<Comment> comments) {
        this.comments = comments;
    }
}
