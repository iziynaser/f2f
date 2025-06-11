package com.f2f.entity.order;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REQUEST_ITEM")
public class RequestItem extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "REQUEST_ITEM_ID")
    private Integer id;

    public RequestItem(){}
}
