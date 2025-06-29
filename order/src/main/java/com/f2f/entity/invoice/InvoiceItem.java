package com.f2f.entity.invoice;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "INVOICE_ITEM")
public class InvoiceItem extends BaseEntity implements Serializable {

    @Column(name = "SEQ_ID")
    private Integer sequenceId;

    @Column(name = "TAXABLE_FLAG")
    private Boolean isTaxable;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "unit_price")
    private Long unitPrice;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "AMOUNT")
    private Integer amount ;

    @Column(name = "DESCRIPTION")
    private String description ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    private Long productItemId;

    private Long inventoryId;
    
    private Long productFeatureItemId;

    @Column(name = "INVOICE_ITEM_TYPE" )
    private String invoiceItemType;

    public InvoiceItem() {
    }
}
