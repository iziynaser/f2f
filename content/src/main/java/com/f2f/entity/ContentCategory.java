package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTENT_CATEGORY")
public class ContentCategory extends BaseEntity implements Serializable {

    @ManyToOne
    private Content content;

    @ManyToOne
    private Category category ;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
