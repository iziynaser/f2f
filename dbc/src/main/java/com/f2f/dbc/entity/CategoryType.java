package com.f2f.dbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.io.Serializable;

@Entity
@Table(name = "CATEGORY_TYPE",uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class CategoryType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public CategoryType() {
    }

    public CategoryType(String name, String description) {
        this.name = name;
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
