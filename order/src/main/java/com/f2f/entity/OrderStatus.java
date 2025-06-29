package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "status")
    private String status;

    @Column(name = "status_date")
    private LocalDateTime statusDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "startDate")
    private Integer startDate;

    @Column(name = "endDate")
    private Integer endDate;

    @Column(name = "registerDate")
    private Integer registerDate;

    @Column(name = "deliveryDate")
    private Integer deliveryDate;

}

