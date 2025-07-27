package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import com.f2f.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;/* تاریخ دریافت سفارش توسط کاربر */

    @Column(name = "delivery_time")
    private LocalTime deliveryTime;/* زمان دریافت سفارش توسط کاربر */

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status")
    private OrderStatusEnum currentStatus = OrderStatusEnum.PRE_ORDER;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderStatus> statusHistory = new HashSet<>();

    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @PrePersist
    public void prePersist() {
        if (currentStatus == null) {
            currentStatus = OrderStatusEnum.PRE_ORDER;
        }
    }
}

