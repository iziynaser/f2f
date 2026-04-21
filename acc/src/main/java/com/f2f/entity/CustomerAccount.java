package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
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

}
