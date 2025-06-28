package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import com.f2f.entity.invoice.Invoice;
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

    @ManyToOne
    @JoinColumn(name = "CREATOR_PERSON_ID")
    private PersonEntity customer;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    @Column(name = "current_status")
    private String currentStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderStatus> statusHistory = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Invoice invoice;

}

