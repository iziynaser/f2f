package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PERIOD_TYPE")
public class PeriodType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    public PeriodType(){

    }
    public PeriodType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
