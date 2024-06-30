package com.f2f.entity.inventory;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
