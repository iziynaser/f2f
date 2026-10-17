package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "STOCK_TRANSFER")
public class StockTransfer extends BaseEntity {

    @Column(name = "product_item_id")
    private Long productItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_warehouse_id")
    private Warehouse sourceWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_warehouse_id")
    private Warehouse destinationWarehouse;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

    @Column(name = "initiate_by")
    private Long initiatedBy; // optional: شخصی که انتقال را ثبت کرده

    @Column(name = "reference_number")
    private String referenceNumber; // optional: شماره سند/برگه

}
