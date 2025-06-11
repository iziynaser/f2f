package com.f2f.entity.acc;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity implements Serializable {

    @Column(name = "EFFECTIVE_DATE")
    private String effectiveDate ;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "COMMENT")
    private String comment;

    @OneToOne
    @JoinColumn(name = "PAYMENT_TYPE_ID")
    private PaymentType paymentType;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Payment() {
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Payment(String effectiveDate, Long amount, String comment, PaymentType paymentType) {
        this.effectiveDate = effectiveDate;
        this.amount = amount;
        this.comment = comment;
        this.paymentType = paymentType;
    }
}
