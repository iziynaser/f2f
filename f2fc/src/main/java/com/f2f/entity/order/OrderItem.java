package com.f2f.entity.order;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseEntity implements Serializable {

    public OrderItem(){}

}
