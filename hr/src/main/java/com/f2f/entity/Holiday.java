package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "HOLIDAY")
public class Holiday extends BaseEntity implements Serializable {

    public Holiday() {
    }

}
