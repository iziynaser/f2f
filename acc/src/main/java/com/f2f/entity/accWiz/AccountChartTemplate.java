package com.f2f.entity.accWiz;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.accWiz.BusinessType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class AccountChartTemplate   extends BaseEntity implements Serializable {

    private String name;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private Boolean active;
}
