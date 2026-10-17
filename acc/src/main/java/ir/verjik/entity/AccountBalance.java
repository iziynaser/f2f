package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private AccountingChart account;

    @ManyToOne
    @JoinColumn(name = "PERIOD_ID",nullable = false)
    private AccountingPeriod period;

    @Column
    private String currency;//for extended develop

    @Column
    private String branch;//for extended develop

    @Column(name = "openingBalance")
    private BigDecimal openingBalance = BigDecimal.ZERO;

    @Column(name = "debitTotal")
    private BigDecimal debitTotal = BigDecimal.ZERO;

    @Column(name = "creditTotal")
    private BigDecimal creditTotal = BigDecimal.ZERO;

    //حذف می کنیم.
    //@Column(name = "closingBalance")
    //private BigDecimal closingBalance = BigDecimal.ZERO;

    @Column(name = "lastUpdated")
    private LocalDateTime lastUpdated;

}
