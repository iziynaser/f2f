package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "INVOICE_STATUS")
public class InvoiceStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

    private Long personId;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ACTION_TYPE_ID")
    private InvoiceActionType invoiceActionType;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;
}
