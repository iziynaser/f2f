package com.f2f.entity.hr;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TRAINING")
public class Training extends BaseEntity implements Serializable {

    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Training() {
    }
}
