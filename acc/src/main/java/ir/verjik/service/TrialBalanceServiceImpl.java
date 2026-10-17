package ir.verjik.service;

import ir.verjik.dto.AccountingPeriodDto;
import ir.verjik.dto.TrialBalanceLineDto;
import ir.verjik.dto.TrialBalanceReportDto;
import ir.verjik.entity.AccountTransactionDetail;
import ir.verjik.entity.AccountingChart;
import ir.verjik.entity.AccountingPeriod;
import ir.verjik.enums.DebitCreditType;
import ir.verjik.repository.AccountTransactionDetailRepository;
import ir.verjik.repository.AccountingPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrialBalanceServiceImpl implements TrialBalanceService {

    private final AccountTransactionDetailRepository detailRepository;
    private final AccountingPeriodRepository periodRepository;

    @Override
    public TrialBalanceReportDto getTrialBalance(Long periodId) {

        AccountingPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        List<AccountTransactionDetail> details =
                detailRepository.findAllPostedForTrialBalance(periodId);

        Map<AccountingChart, List<AccountTransactionDetail>> grouped =
                details.stream().collect(Collectors.groupingBy(AccountTransactionDetail::getAccountingChart));

        List<TrialBalanceLineDto> lines = new ArrayList<>();
        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;

        for (Map.Entry<AccountingChart, List<AccountTransactionDetail>> e : grouped.entrySet()) {

            AccountingChart acc = e.getKey();
            List<AccountTransactionDetail> list = e.getValue();

            BigDecimal debitSum = BigDecimal.ZERO;
            BigDecimal creditSum = BigDecimal.ZERO;

            for (AccountTransactionDetail d : list) {
                if (d.getDebitCreditType()== DebitCreditType.DEBIT)
                    debitSum = debitSum.add(d.getAmountFunctional());
                else
                    creditSum = creditSum.add(d.getAmountFunctional());
            }

            TrialBalanceLineDto line = new TrialBalanceLineDto();
            line.setAccountCode(acc.getAccountCode());
            line.setAccountName(acc.getName());
            line.setDebitTotal(debitSum);
            line.setCreditTotal(creditSum);
            line.setNetBalance(debitSum.subtract(creditSum));

            lines.add(line);

            totalDebit = totalDebit.add(debitSum);
            totalCredit = totalCredit.add(creditSum);
        }

        TrialBalanceReportDto dto = new TrialBalanceReportDto();
        dto.setPeriod(mapToAccountingPeriodDto(period));
        dto.setLines(lines);
        dto.setTotalDebit(totalDebit);
        dto.setTotalCredit(totalCredit);

        return dto;
    }

    private AccountingPeriodDto mapToAccountingPeriodDto(AccountingPeriod period) {
        AccountingPeriodDto dto = new AccountingPeriodDto();
        dto.setFiscalYear(period.getFiscalYear());
        dto.setPeriodName(period.getPeriodName());
        dto.setPeriodNumber(period.getPeriodNumber());
        dto.setFromDate(period.getFromDate());
        dto.setToDate(period.getToDate());
        dto.setIsClosed(period.getIsClosed());
        return dto;
    }
}
