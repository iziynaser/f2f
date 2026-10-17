package ir.verjik.mapper;

import ir.verjik.dto.transactions.AccountingTransactionResponseDto;
import ir.verjik.dto.transactions.PeriodDto;
import ir.verjik.dto.transactions.TransactionDetailDto;
import ir.verjik.entity.AccountTransactionDetail;
import ir.verjik.entity.AccountingTransaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountingTransactionMapper {

    public AccountingTransactionResponseDto toDto(AccountingTransaction tx) {

        AccountingTransactionResponseDto dto =
                new AccountingTransactionResponseDto();

        dto.setId(tx.getId());
        dto.setTransactionNumber(tx.getTransactionNumber());

        dto.setTransactionType(
                tx.getTransactionType() != null
                        ? tx.getTransactionType().name()
                        : null);

        dto.setTransactionStatus(
                tx.getTransactionStatus() != null
                        ? tx.getTransactionStatus().name()
                        : null);

        dto.setTransactionDate(tx.getTransactionDate());

        dto.setDescription(tx.getDescription());

        // period
        if (tx.getAccountingPeriod() != null) {

            PeriodDto p = new PeriodDto();

            p.setId(tx.getAccountingPeriod().getId());
            p.setPeriodName(tx.getAccountingPeriod().getPeriodName());
            p.setFiscalYear(tx.getAccountingPeriod().getFiscalYear());

            dto.setPeriod(p);
        }

        // details
        List<TransactionDetailDto> details =
                tx.getAccountTransactionDetails()
                        .stream()
                        .map(this::mapDetail)
                        .toList();

        dto.setDetails(details);

        return dto;
    }

    private TransactionDetailDto mapDetail(AccountTransactionDetail d) {

        TransactionDetailDto dto =
                new TransactionDetailDto();

        dto.setId(d.getId());

        dto.setSequenceId(d.getSequenceId());

        dto.setDebitCreditType(
                d.getDebitCreditType() != null
                        ? d.getDebitCreditType().name()
                        : null);

        dto.setAmountFunctional(d.getAmountFunctional());

        dto.setDescription(d.getDescription());

        if (d.getAccountingChart() != null) {

            dto.setAccountCode(
                    d.getAccountingChart().getAccountCode());

            dto.setAccountName(
                    d.getAccountingChart().getName());
        }

        return dto;
    }
}
