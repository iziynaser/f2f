package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "COMMENT_TARGET_ID")
    private CommentTarget commentTarget;

    @Column(name = "SUBJECT")
    private String subject ;

    @OneToMany(mappedBy = "comment")
    private List<CommentBenefits> benefits=new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    private List<CommentUpsets> upsets=new ArrayList<>();

    @Column(name = "BODY")
    private String body ;

    @Column(name = "STATUS")
    private String status;

    private Long userAccountId;

    @OneToOne(mappedBy = "comment",cascade = CascadeType.ALL)
    private CommentLikes commentLikes;

    public Comment() {
    }
}
