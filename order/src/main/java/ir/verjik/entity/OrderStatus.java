package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.OrderStatusEnum;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatusEnum status;

    @Column(name = "status_date")
    private LocalDateTime statusDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "startDate")
    private LocalDateTime  startDate;

    @Column(name = "endDate")
    private LocalDateTime  endDate;

    @Column(name = "registerDate")
    private LocalDateTime  registerDate;

    @Column(name = "deliveryDate")
    private LocalDateTime  deliveryDate;

}

