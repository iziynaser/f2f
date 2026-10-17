package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount extends BaseEntity {

    @Column(name = "OPENNING_BALANCE",nullable = false)
    private BigDecimal openningBalance = BigDecimal.ZERO;

    @Column(name = "CURRENT_BALANCE",nullable = false)
    private BigDecimal currentBalance = BigDecimal.ZERO;

    @Column(name = "OPEN_DATE")
    private LocalDate openningDate;

    @Column(name = "IS_ACTIVE")
    private Boolean active = true;

    @Column(name = "PERSON_ID")
    private Long personId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private AccountingChart account;

}
