package com.f2f.entity.inventory;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "INVENTORY")
public class Inventory extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    public Inventory() {
    }

    public Inventory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
