package com.f2f.entity.content;

import com.f2f.entity.common.Category;
import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ARTICLE")
public class Article extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "TITLE")
    private String title;

    @ElementCollection
    private List<String> keywords ;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "AUTHOR")
    private String author ;

    @Column(name = "DESCRIPTION")
    private String description ;

    @Column(name = "DATE_CREATED")
    private String dateCreated ;

    @Column(name = "DATE_MODIFIED")
    private String dateModified ;

    @OneToMany(mappedBy = "article")
    private List<Page> pages;

    public Article() {
    }

    public Article(String name, String title, List<String> keywords, Category category, String author, String description, String dateCreated, String dateModified, List<Page> pages) {
        this.name = name;
        this.title = title;
        this.keywords = keywords;
        this.category = category;
        this.author = author;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        //sb.append("id "+ id +",");
        sb.append("name: "+ name +",");
        sb.append("title: "+ title +",");
        sb.append("keywords: "+ keywords +",");
        sb.append("category: "+ category +",");
        sb.append("author: "+ author +",");
        sb.append("description: "+ description +",");
        sb.append("dateCreated: "+ dateCreated +",");
        sb.append("dateModified: "+ dateModified +",");

        return sb.toString();
    }

}
