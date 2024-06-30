package com.f2f.entity.order;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST")
public class Request extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "REQUEST_ID")
    private Integer id;

}
