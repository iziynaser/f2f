package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ARTICLE")
public class Article extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "TITLE")
    private String title;

    @ElementCollection
    private List<String> keywords ;

    //@Column(name = "CATEGORY")
    private Long categoryId;

    @Column(name = "AUTHOR")
    private String author ;

    @Column(name = "DESCRIPTION")
    private String description ;

//    @Column(name = "DATE_CREATED")
//    private String dateCreated ;

    @Column(name = "DATE_MODIFIED")
    private String dateModified ;

    @OneToMany(mappedBy = "article")
    private List<Page> pages;

    public String toString(){
        StringBuffer sb = new StringBuffer();
        //sb.append("id "+ id +",");
        sb.append("name: "+ name +",");
        sb.append("title: "+ title +",");
        sb.append("keywords: "+ keywords +",");
        sb.append("category: "+ categoryId +",");
        sb.append("author: "+ author +",");
        sb.append("description: "+ description +",");
        //sb.append("dateCreated: "+ dateCreated +",");
        sb.append("dateModified: "+ dateModified +",");

        return sb.toString();
    }

}
