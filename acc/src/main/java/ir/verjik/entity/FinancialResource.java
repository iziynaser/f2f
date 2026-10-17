package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.ResourceStatus;
import ir.verjik.enums.ResourceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "FINANCIAL_RESOURCE")
public class FinancialResource extends BaseEntity {

    @Column(name = "NUMBER_")
    private String number;       // شماره چک یا سفته

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;   // سررسید

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "OWNER_PERSON_ID")
    private Long ownerPersonId;  // مالک چک یا پرداخت کننده

    @Enumerated(EnumType.STRING)
    private ResourceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATED_TRANSACTION")
    private AccountingTransaction relatedTransaction;

    @Enumerated(EnumType.STRING)
    private ResourceType type;
}
