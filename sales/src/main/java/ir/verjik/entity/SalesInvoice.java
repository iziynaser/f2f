package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.SalesStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SALES_INVOICE")
public class SalesInvoice extends BaseEntity {
    private String invoiceNumber;
    private Long customerId;
    private LocalDate invoiceDate;

    @Enumerated(EnumType.STRING)
    private SalesStatus status;

    private BigDecimal totalAmount;
}