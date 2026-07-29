package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNTING_CURRENCY")
public class AccountingCurrency extends BaseEntity {

    @Column(name = "currency_name")
    private String currencyname ;

}
