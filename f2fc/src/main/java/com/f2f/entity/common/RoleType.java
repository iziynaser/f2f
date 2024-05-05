package com.f2f.entity.common;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ROLE_TYPE")
public class RoleType extends BaseEntity {

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

    public RoleType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
