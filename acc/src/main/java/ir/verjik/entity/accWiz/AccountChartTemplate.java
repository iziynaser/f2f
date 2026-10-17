package ir.verjik.entity.accWiz;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.accWiz.BusinessType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

@Entity
public class AccountChartTemplate   extends BaseEntity implements Serializable {

    private String name;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private Boolean active;
}
