package com.f2f.entity.accWiz;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.AccountLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class AccountChartTemplateItem    extends BaseEntity implements Serializable {


    private String accountCode;

    private String accountName;

    private Integer levelIndex;

    @Enumerated(EnumType.STRING)
    private AccountLevel level;

    private String parentCode;

    @ManyToOne
    private AccountChartTemplate template;
}
