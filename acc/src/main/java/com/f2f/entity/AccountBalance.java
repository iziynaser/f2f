package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(
        name="ACCOUNT_BALANCE",
        uniqueConstraints = {
                @UniqueConstraint(columnNames={"ACCOUNT_ID","PERIOD_ID"})
        }
)
public class AccountBalance  extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID",nullable = false)
    private AccountsChart account;

    @ManyToOne
    @JoinColumn(name = "PERIOD_ID",nullable = false)
    private AccountingPeriod period;

    @Column(name = "openingBalance")
    private BigDecimal openingBalance = BigDecimal.ZERO;

    @Column(name = "debitTotal")
    private BigDecimal debitTotal = BigDecimal.ZERO;

    @Column(name = "creditTotal")
    private BigDecimal creditTotal = BigDecimal.ZERO;

    @Column(name = "lastUpdated")
    private LocalDateTime lastUpdated;


}



