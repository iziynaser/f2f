package com.f2f.entity.common;

import com.f2f.persistence.entity.BaseEntity;
import com.f2f.persistence.entity.UserAccountEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "USER_ACCOUNT")
    private UserAccountEntity userAccountEntity;

    @OneToOne(mappedBy = "comment",cascade = CascadeType.ALL)
    private CommentLikes commentLikes;

    public Comment() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserAccountEntity getUserAccountEntity() {
        return userAccountEntity;
    }

    public void setUserAccountEntity(UserAccountEntity userAccountEntity) {
        this.userAccountEntity = userAccountEntity;
    }

    public CommentLikes getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(CommentLikes commentLikes) {
        this.commentLikes = commentLikes;
    }

    public CommentTarget getCommentTarget() {
        return commentTarget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCommentTarget(CommentTarget commentTarget) {
        this.commentTarget = commentTarget;
    }

    public List<CommentBenefits> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<CommentBenefits> benefits) {
        this.benefits = benefits;
    }

    public List<CommentUpsets> getUpsets() {
        return upsets;
    }

    public void setUpsets(List<CommentUpsets> upsets) {
        this.upsets = upsets;
    }
}
