package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TRAINING")
public class Training extends BaseEntity implements Serializable {

    @ManyToOne
    private PersonEntity person;

    public Training() {
    }
}
