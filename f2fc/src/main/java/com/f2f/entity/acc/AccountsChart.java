package com.f2f.entity.acc;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ACCOUNTS_CHART")
public class AccountsChart extends BaseEntity implements Serializable {

    @Column(name = "ACCOUNTS_NAME")
    private String name;//name

    //@Id
    @Column(name = "ACCOUNT_CODE",nullable = false,unique = true)
    private String code ;

    @Column(name = "ACCOUNTS_DESC")
    private String description;

    //@OneToOne
    //@JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @Column(name = "ACCOUNTS_COLOR")
    private String color;

    @Column(name = "ACCOUNTS_STATUS")
    private String status;

    //@OneToOne
    //@JoinColumn(name = "ACCOUNTS_TYPE_ID")
    private AccountType accountType;

    //@OneToOne
    //@JoinColumn(name = "ACCOUNT_GROUP_ID")
    private AccountGroup accountGroup;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "PARENT_ACCOUNT_CODE",nullable = true)
    private AccountsChart parentAccount;

    @OneToMany(fetch = FetchType.LAZY)
    //@JoinTable(name="PARENT_ACCOUNT_CODE", joinColumns = {@JoinColumn(name = "ACCOUNT_CODE")},
    //           inverseJoinColumns = {@JoinColumn(name = "PARENT_ACCOUNT_CODE")})
    private List<AccountsChart> subAccounts ;//= new ArrayList<AccountsChart>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AccountsChart getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(AccountsChart parentAccount) {
        this.parentAccount = parentAccount;
    }

    public List<AccountsChart> getSubAccounts() {
        return subAccounts;
    }

    public void setSubAccounts(List<AccountsChart> subAccounts) {
        this.subAccounts = subAccounts;
    }

    public AccountsChart() {
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }

    public AccountsChart(String name, String code, String description, Currency currency, String color, String status, AccountType accountType, AccountGroup accountGroup, AccountsChart parentAccount, List<AccountsChart> subAccounts) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.currency = currency;
        this.color = color;
        this.status = status;
        this.accountType = accountType;
        this.accountGroup = accountGroup;
        this.parentAccount = parentAccount;
        this.subAccounts = subAccounts;
    }
}
