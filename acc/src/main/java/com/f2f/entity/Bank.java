package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "BANK")
public class Bank extends BaseEntity {

    @Column(name = "NAME")
    private String name ;

    @Column(name = "BANK_CODE")
    private Integer BankCode ;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name="FIRST_BALANCE")
    private String firstBalance;

    public Integer getBankCode() {
        return BankCode;
    }

    public void setBankCode(Integer bankCode) {
        BankCode = bankCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFirstBalance() {
        return firstBalance;
    }

    public void setFirstBalance(String firstBalance) {
        this.firstBalance = firstBalance;
    }

    public Bank() {
    }

    public Bank(String name, String branch, String firstBalance) {
        this.name = name;
        this.branch = branch;
        this.firstBalance = firstBalance;
    }
}
