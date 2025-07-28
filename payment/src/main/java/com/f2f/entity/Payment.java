package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity implements Serializable {

    @Column(name = "EFFECTIVE_DATE")
    private String effectiveDate ;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "COMMENT")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE", nullable = false)
    private PaymentType paymentType;


    public Payment() {
    }

    public Payment(String effectiveDate, Long amount, String comment, PaymentType paymentType) {
        this.effectiveDate = effectiveDate;
        this.amount = amount;
        this.comment = comment;
        this.paymentType = paymentType;
    }
}
