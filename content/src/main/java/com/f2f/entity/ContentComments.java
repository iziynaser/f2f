package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

 
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(
        name = "CONTENT_COMMENTS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"CONTENT_ID","COMMENT_ID"}))
public class ContentComments extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
