package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TERMINATION_TYPE")
public class TerminationType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

}
