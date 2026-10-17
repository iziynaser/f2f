package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
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
