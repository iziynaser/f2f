package com.f2f.entity;

 
import java.time.LocalDate;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STOCKBATCHES")
public class StockBatches  extends BaseEntity {

    //ManyToOne
    private Long productItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    private Long batchNumber;// شماره سری یا پارت

    private LocalDate entryDate;

    private LocalDate arrivalDate;

    private LocalDate manufactureDate;

    private LocalDate expiryDate;

    private Integer quantity;

    private Integer sold;

    private Integer remaining;

    private Boolean available;

    private LocalDate outOfStockDate;

}
