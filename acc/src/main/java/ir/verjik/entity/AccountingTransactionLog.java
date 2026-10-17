package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.TransactionLogType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ACCOUTING_TRANSACTION_LOG")
public class AccountingTransactionLog extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRANSACTION_ID", nullable = false)
    private AccountingTransaction transaction;

    @Column(nullable = false)
    private LocalDateTime logDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionLogType logType;
    // EDIT, DELETE, STATUS_CHANGE, PERIOD_CLOSE

    @Column
    private String oldValue;

    @Column
    private String newValue;

    @Column
    private Long userId;
}

