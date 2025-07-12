package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.StockOutReason;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "STOCKOUT")
public class StockOut  extends BaseEntity {

    //ManyToOne
    private Long productItemId;

    @ManyToOne
    private Warehouse warehouse;

    private int quantity;

    private LocalDateTime stockDate;

    @Enumerated(EnumType.STRING)
    private StockOutReason reason;

    private Long receiverPersonId ;

    // مربوط به کدام ورود کالا بوده ؟؟
    @ManyToOne
    private StockIn stockIn;
}
