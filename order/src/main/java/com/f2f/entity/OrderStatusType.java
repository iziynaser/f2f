package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_STATUS_TYPE")
public class OrderStatusType extends BaseEntity implements Serializable  {

    //jari , tahvilshode , marjooee , laghvshode ,

    @Column(name = "STATUS_NAME")
    private String name;

    public OrderStatusType(){}
}
