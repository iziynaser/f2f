package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "RESPONSIBILITY")
public class Responsibility extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "POSITION_ID")  // نام ستون خارجی در جدول RESPONSIBILITY
    private Position position;

    @Column(name = "NAME")
    private String name ;

    @Column(name = "DESCRIPTION")
    private String description;

}
