package com.f2f.entity.project;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description ;

    @ManyToOne
    private Project project;

    public Task() {
    }

    public Task( String name, String description, Project project) {
        this.name = name;
        this.description = description;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
