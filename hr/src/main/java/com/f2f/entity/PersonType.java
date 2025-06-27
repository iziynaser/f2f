package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "PERSON_TYPE.sql")
public class PersonType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "DESCRIPTION")
    private String description;

    public PersonType() {
    }

    public PersonType(Integer version, String description) {
        this.version = version;
        this.description = description;
    }

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
}
