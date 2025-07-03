package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "SHOPPING")
public class Shopping extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private PersonEntity customer;

    @OneToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "status")
    private String status; // مثلا IN_PROGRESS, COMPLETED, CANCELLED

    // این کلاس بیشتر برای ثبت تاریخچه فرایند خرید است
}
