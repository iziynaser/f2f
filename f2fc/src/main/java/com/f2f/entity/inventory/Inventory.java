package com.f2f.entity.inventory;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INVENTORY")
public class Inventory extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    public Inventory() {
    }
}
