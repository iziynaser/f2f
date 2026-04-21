package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.AccountNature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="ACCOUNT_CATEGORY")
public class AccountCategory  extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    private AccountNature nature;

    @Column(name = "CODE")
    private String code;
}
