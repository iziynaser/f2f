package com.f2f.entity.order;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import com.f2f.entity.acc.invoice.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    public PersonEntity getCustomer() {
        return customer;
    }

    public void setCustomer(PersonEntity customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Set<OrderStatus> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(Set<OrderStatus> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Order(Long id){
        super(id);
    }

}

