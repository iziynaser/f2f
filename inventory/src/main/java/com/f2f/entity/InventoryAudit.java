package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "INVENTORYAUDIT")
public class InventoryAudit   extends BaseEntity {

    private Long productItemId ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse ;

    private Integer quantityChanged ;

    private String operationType ;// in,out,adjustment,transfer

    private LocalDateTime operationDate ;

    private Long personId ;

}
