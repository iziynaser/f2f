package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.AccountLevel;
import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNTS_CHART",
uniqueConstraints = {@UniqueConstraint(columnNames = {"ACCOUNT_CODE"})})
public class AccountsChart extends BaseEntity implements Serializable {

    @Column(name = "ACCOUNTS_NAME")
    private String name;//name

    //@Id
    @Column(name = "ACCOUNT_CODE",nullable = false,unique = true)
    private String accountCode ;

    @Column(name = "ACCOUNTS_DESC")
    private String description;

    @Column(name = "ACCOUNTS_COLOR")
    private String color;

    @Column(name = "ACCOUNTS_STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_GROUP_ID")
    private AccountGroup accountGroup;

    @OneToMany(mappedBy = "parentAccount", fetch = FetchType.LAZY)
    @BatchSize(size = 50)
    private List<AccountsChart> subAccounts ;//= new ArrayList<AccountsChart>();

    @Column(name = "LEVEL_INDEX", nullable = false)
    private int levelIndex;// سطح حساب (1 = کل، 2 = معین، 3 = تفضیلی، ...)

    @Enumerated(EnumType.STRING)
    @Column(name = "LEVEL_TYPE", nullable = false)
    private AccountLevel accountLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @BatchSize(size = 50)
    @JoinColumn(name = "PARENT_ID")
    private AccountsChart parentAccount;


    @Enumerated(EnumType.STRING)
    @Column(name = "NORMAL_BALANCE", nullable = false)
    private DebitCreditType normalBalance;

    @Enumerated(EnumType.STRING)
    @Column(name="ACCOUNT_NATURE", nullable=false)
    private AccountNature accountNature;

    @Column(name="IS_CONTROL_ACCOUNT")
    private Boolean controlAccount;//در حساب‌های مانند مشتریان و فروشندگان باید مشخص شود که معین‌ها زیر مجموعه چه کلّی هستند.

    @Column(name="IS_POSTABLE")
    private Boolean postable = true;//برای جلوگیری از اشتباه کاربر در ثبت سند روی حساب‌هایی که shouldn’t accept postings.

    @Column(name = "IS_ACTIVE")
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private AccountCategory category;

    public AccountsChart() {
    }

    public AccountsChart(String name, String description, String color, String status, AccountType accountType, AccountGroup accountGroup, AccountsChart parentAccount, List<AccountsChart> subAccounts) {
        this.name = name;
        //this.code = code;
        this.description = description;
        //this.currency = currency;
        this.color = color;
        this.status = status;
        this.accountType = accountType;
        this.accountGroup = accountGroup;
        this.parentAccount = parentAccount;
        this.subAccounts = subAccounts;
    }

}
