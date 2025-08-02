package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT_LOG")
@Getter
@Setter
public class PaymentLog extends BaseEntity implements Serializable {

    @Column(name = "PAYMENT_REQUEST_ID", nullable = false)
    private Long paymentRequestId;

    @Column(name = "LOG_TIME", nullable = false)
    private LocalDateTime logTime;

    @Column(name = "EVENT_TYPE", length = 50, nullable = false)
    private String eventType;

    @Column(name = "MESSAGE", length = 500)
    private String message;

    @Column(name = "PERFORMED_BY", length = 50)
    private String performedBy;
}
