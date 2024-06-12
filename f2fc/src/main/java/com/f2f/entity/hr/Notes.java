package com.f2f.entity.hr;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "NOTES")
public class Notes extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
