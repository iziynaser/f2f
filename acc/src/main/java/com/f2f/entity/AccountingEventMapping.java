package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.AccountingEventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AccountingEventMapping extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AccountingEventType eventType;

    @ManyToOne
    private AccountsChart account;

    private String description;

}

