package com.f2f.entity.order;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST_ITEM")
public class RequestItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "REQUEST_ITEM_ID")
    private Integer id;

}
