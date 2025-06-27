package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "REQUEST")
public class Request extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "REQUEST_ID")
    private Integer id;

    public Request(){}

}
