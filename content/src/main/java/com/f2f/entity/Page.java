package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PAGE")
public class Page extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @Column(name = "PAGE_NUMBER")
    private Short pageNumber ;

    @Column(name = "TITLE")
    private String title ;

    @Column(name = "BODY")
    private String body ;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "SLUG", unique = true)
    private String slug;

    @Column(name = "CONTENT_ID")
    private Long contentId;  // اختیاری


    private Long commentTargetId;


    public Page() {
    }

    public Page(Article article, Short pageNumber, String title, String body, String dateCreated, String dateModified) {
        this.article = article;
        this.pageNumber = pageNumber;
    }

}
