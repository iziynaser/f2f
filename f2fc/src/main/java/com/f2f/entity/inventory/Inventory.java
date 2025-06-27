package com.f2f.entity.inventory;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


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
