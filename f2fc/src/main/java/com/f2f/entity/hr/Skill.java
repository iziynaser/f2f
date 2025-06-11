package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SKILL")
public class Skill extends BaseEntity implements Serializable {

    @Column(name = "SKILL_NAME")
    private String name;

    @ManyToOne
    private PersonEntity person ;

    @Column(name = "EXPERIENCE")
    private int experience ;

    @Column(name="SKILL_LEVEL")
    private int skillLevel;

}
