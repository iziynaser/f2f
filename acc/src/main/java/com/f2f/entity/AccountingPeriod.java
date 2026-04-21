package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "ACCOUNTING_PERIOD",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"COMPANY_ID","BRANCH_ID","PERIOD_NUMBER"})
        }
)
public class AccountingPeriod extends BaseEntity implements Serializable {

    @Column(name="PERIOD_NAME")
    private String periodName; // "فروردین 1403"

    @Column(name="FISCAL_YEAR")
    private Integer fiscalYear;

    @Column(name = "FROM_DATE")
    private LocalDate fromDate ;

    @Column(name = "TO_DATE")
    private LocalDate toDate;

    @Column(name = "PERIOD_NUMBER")
    private Short periodNumber;

    @Column(name = "IS_CLOSED")
    public Boolean isClosed = false ;

    @OneToMany(mappedBy = "accountingPeriod")
    private List<AccountingTransaction> transactions;

    public AccountingPeriod() {
    }

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "BRANCH_ID")
    private Long branchId; // optional

    public AccountingPeriod(LocalDate fromDate, LocalDate toDate, Short periodNumber) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.periodNumber = periodNumber;
    }

}
