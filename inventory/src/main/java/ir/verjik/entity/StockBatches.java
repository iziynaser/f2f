package ir.verjik.entity;

 
import java.time.LocalDate;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STOCK_BATCHES")
public class StockBatches  extends BaseEntity {

    //ManyToOne
    @Column(name = "product_item_id")
    private Long productItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "batch_number")
    private Long batchNumber;// شماره سری یا پارت

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "remaining")
    private Integer remaining;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "out_stock_date")
    private LocalDate outOfStockDate;

}
