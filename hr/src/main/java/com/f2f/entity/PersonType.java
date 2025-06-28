package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PERSON_TYPE.sql")
public class PersonType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

//    @Column(name = "VERSION")
//    private Integer version;

    @Column(name = "DESCRIPTION")
    private String description;

    public PersonType() {
    }

}
