package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SHAHR")
public class Shahr extends BaseEntity implements Serializable {

    @Column(name = "SHAHR_NAME")
    private String name;

    @ManyToOne
    private Ostan ostan;
}
