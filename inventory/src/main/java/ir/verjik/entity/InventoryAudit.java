package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "INVENTORY_AUDIT")
public class InventoryAudit   extends BaseEntity {

    private Long productItemId ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse ;

    private Integer quantityChanged ;

    private String operationType ;// in,out,adjustment,transfer

    private LocalDateTime operationDate ;

    private Long personId ;

}
