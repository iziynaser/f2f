package com.f2f.entity.content;

import com.f2f.entity.common.Category;
import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
