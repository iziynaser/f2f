package com.f2f.entity.entrance;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "VACATION_TYPE")
public class VacationType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;
}
