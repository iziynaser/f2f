package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.eums.CommentStatus;
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
    @Enumerated(EnumType.STRING)
    private CommentStatus status;

    private Long userAccountId;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentReaction> reactions = new ArrayList<>();

    public Comment() {
    }
}
