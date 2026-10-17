package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.StockOutReason;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "stock_out")
public class StockOut  extends BaseEntity {

    //ManyToOne
    @Column(name = "product_item_id")
    private Long productItemId;

    @ManyToOne
    private Warehouse warehouse;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "stock_date")
    private LocalDateTime stockDate;

    @Enumerated(EnumType.STRING)
    private StockOutReason reason;

    @Column(name = "receiver_person_id")
    private Long receiverPersonId ;

    // مربوط به کدام ورود کالا بوده ؟؟
    @ManyToOne
    private StockIn stockIn;
}
