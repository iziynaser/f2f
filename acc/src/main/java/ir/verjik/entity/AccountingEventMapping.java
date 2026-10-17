package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.AccountingEventType;
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
    private AccountingChart account;

    private String description;

}

