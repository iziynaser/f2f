package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "BANK")
public class Bank extends BaseEntity {

    @Column(name = "NAME")
    private String name ;

    @Column(name = "BANK_CODE")
    private Integer BankCode ;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name="FIRST_BALANCE")
    private BigDecimal firstBalance;

    public Bank() {
    }

    public Bank(String name, String branch, BigDecimal firstBalance) {
        this.name = name;
        this.branch = branch;
        this.firstBalance = firstBalance;
    }
}
