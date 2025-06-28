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
@Table(name = "SKILL_TYPE")
public class SkillType extends BaseEntity {

    @Column(name = "SKILL_TYPE_NAME")
    private String name;

    @Column(name = "SKILL_TYPE_RATE")
    private String rate ;

}
