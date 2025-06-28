package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "BENEFIT_TYPE")
public class BenefitType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

}
