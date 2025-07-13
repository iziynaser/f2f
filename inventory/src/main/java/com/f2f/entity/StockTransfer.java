package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "STOCK_TRANSFER")
public class StockTransfer extends BaseEntity {

    private Long productItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_warehouse_id")
    private Warehouse sourceWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_warehouse_id")
    private Warehouse destinationWarehouse;

    private Integer quantity;

    private LocalDateTime transferDate;

    private Long initiatedBy; // optional: شخصی که انتقال را ثبت کرده

    private String referenceNumber; // optional: شماره سند/برگه

}
