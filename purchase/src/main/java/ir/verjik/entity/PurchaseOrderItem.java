package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "PURCHASE_ORDER_ITEM")
public class PurchaseOrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseOrder purchaseOrder;

    private Long productItemId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;
}
