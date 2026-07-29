package com.f2f.dto;

import com.f2f.enums.DebitCreditType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountTransactionDetailCreateDTO {
    BigDecimal closing;
    DebitCreditType debitCreditType;
    Long id;

    public AccountTransactionDetailCreateDTO(Long id, BigDecimal closing, DebitCreditType debitCreditType) {
        this.id = id;
        this.closing = closing;
        this.debitCreditType = debitCreditType;
    }
}
