package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "DEPARTMENT")
public class DepartmentB extends BaseEntity implements Serializable {

    @Column(name = "DESCRIPTION")
    private String description;
}
