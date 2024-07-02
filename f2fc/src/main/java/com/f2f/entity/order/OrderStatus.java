package com.f2f.entity.order;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus extends BaseEntity implements Serializable {

    private int statusDate ;
    private int startDate;
    private int endDate;
    private int registerDate;
    private int deliveryDate;

    private OrderStatusType orderStatusType;

    public OrderStatus(){}

}
