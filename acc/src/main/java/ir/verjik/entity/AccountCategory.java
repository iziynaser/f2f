package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.AccountNature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
