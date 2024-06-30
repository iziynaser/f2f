package com.f2f.entity.content;

import com.f2f.entity.common.CommentTarget;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PAGE")
public class Page extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @Column(name = "PAGE_NUMBER")
    private Short pageNumber ;

//    @Column(name = "TITLE")
//    private String title ;

//    @Column(name = "BODY")
//    private String body ;

    @Column(name = "DATE_CREATED")
    private String dateCreated;

    @Column(name = "DATE_MODIFIED")
    private String dateModified ;

//    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "comment_target_id")
//    private CommentTarget commentTarget;

    public Page() {
    }

    public Page(Article article, Short pageNumber, String title, String body, String dateCreated, String dateModified, CommentTarget commentTarget) {
        this.article = article;
        this.pageNumber = pageNumber;
        //this.title = title;
        //this.body = body;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
//        this.commentTarget = commentTarget;
    }

//    public CommentTarget getCommentTarget() {
//        return commentTarget;
//    }
//
//    public void setCommentTarget(CommentTarget commentTarget) {
//        this.commentTarget = commentTarget;
//    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Short getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Short pageNumber) {
        this.pageNumber = pageNumber;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
