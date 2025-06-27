package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "PAYMENT_METHOD")
public class PaymentMethod extends BaseEntity implements Serializable {

    private String fromDate ;

    private String throughDate ;

    private PaymentMethod paymentMethod;

    private Long productId;

}
