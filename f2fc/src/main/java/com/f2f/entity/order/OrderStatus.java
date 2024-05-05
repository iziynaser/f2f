package com.revengemission.sso.oauth2.server.f2f.domain.order;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus extends BaseEntity implements Serializable {

    private int statusDate ;
    private int startDate;
    private int endDate;
    private int registerDate;
    private int deliveryDate;

}
