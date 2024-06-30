package com.f2f.entity.content;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAG")
public class Tag extends BaseEntity implements Serializable {

    @Column(name = "LANGUAGE")
    private String language ;

    @Column(name = "name")
    private String name ;

    @ManyToMany(mappedBy = "tags")
    private List<Content> contents = new ArrayList<>();

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
