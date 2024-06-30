package com.f2f.entity.acc;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNTING_PERIOD")
public class AccountingPeriod extends BaseEntity implements Serializable {

    @Column(name = "FROM_DATE")
    private Integer fromDate ;

    @Column(name = "TO_DATE")
    private Integer toDate;

    @Column(name = "PERIOD_NUMBER")
    private Short periodNumber;

    public Integer getFromDate() {
        return fromDate;
    }

    public void setFromDate(Integer fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getToDate() {
        return toDate;
    }

    public void setToDate(Integer toDate) {
        this.toDate = toDate;
    }

    public Short getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(Short periodNumber) {
        this.periodNumber = periodNumber;
    }

    public AccountingPeriod() {
    }

    public AccountingPeriod(Integer fromDate, Integer toDate, Short periodNumber) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.periodNumber = periodNumber;
    }
}
