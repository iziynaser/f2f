package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "RESPONSIBILITY")
public class Responsibility extends BaseEntity implements Serializable {

    private Position position;

    @Column(name = "NAME")
    private String name ;

    @Column(name = "DESCRIPTION")
    private String description;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public Responsibility() {
    }
}
