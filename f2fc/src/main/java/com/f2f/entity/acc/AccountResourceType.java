package com.f2f.entity.acc;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_RESOURCE_TYPE")
public class AccountResourceType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

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

    public AccountResourceType() {
    }

    public AccountResourceType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
