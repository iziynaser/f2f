package com.f2f.entity.hr;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TERMINATION_TYPE")
public class TerminationType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TerminationType(){

    }
    public TerminationType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
