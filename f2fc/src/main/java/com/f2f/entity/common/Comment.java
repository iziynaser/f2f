package com.f2f.entity.common;

import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    //@ElementCollection
    @OneToMany(mappedBy = "comment")
    private List<CommentBenefits> benefits=new ArrayList<>();

    //@ElementCollection
    @OneToMany(mappedBy = "comment")
    private List<CommentUpsets> upsets=new ArrayList<>();

    @Column(name = "BODY")
    private String body ;

    @Column(name = "STATUS")
    private String status;

//    @OneToOne
//    @JoinColumn(name = "USER_ACCOUNT")
    private Long userAccountId;

    @OneToOne(mappedBy = "comment",cascade = CascadeType.ALL)
    private CommentLikes commentLikes;

    public Comment() {
    }
}
