package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import com.f2f.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order  extends BaseEntity implements Serializable {

    @Column(name = "order_code",unique = true)
    private String orderCode ;

    @ManyToOne
    @JoinColumn(name = "CREATOR_PERSON_ID")
    private PersonEntity customer;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status")
    private OrderStatusEnum currentStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderStatus> statusHistory = new HashSet<>();

    @Column(name = "invoice_id")
    private Long invoiceId;

}

