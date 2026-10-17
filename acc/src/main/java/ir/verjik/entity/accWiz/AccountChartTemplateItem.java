package ir.verjik.entity.accWiz;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.AccountLevel;
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
