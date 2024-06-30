package com.f2f.entity.order;

import com.f2f.entity.Delivery;
import com.f2f.entity.acc.PaymentType;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class Order extends BaseEntity implements Serializable {

    public Order() {
    }

    @Column(name = "IDENTIFIER")
    private String identifier;

    @Column(name = "AMOUNT")
    private Long amount ;

    @OneToOne
    private Delivery delivery;

    //transaction????

    //deliveryInfo from company???

    //list of status..????

    @OneToOne
    private PaymentType paymentType;

}
