package ir.verjik.service;

import com.f2f.dto.*;
import ir.verjik.dto.BalanceSheetDto;
import ir.verjik.dto.ProfitAndLossDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FinancialReportServiceImpl implements FinancialReportService {
    @Override
    public BalanceSheetDto getBalanceSheet(Long periodId) {
        return null;
    }

    @Override
    public ProfitAndLossDto getProfitAndLoss(Long periodId) {
        return null;
    }
}

//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class FinancialReportServiceImpl implements FinancialReportService {
//
//    private final AccountBalanceRepository balanceRepository;
//    private final AccountingPeriodRepository periodRepository;
//
//    @Override
//    public BalanceSheetDto getBalanceSheet(Long periodId) {
//
//        AccountingPeriod period = periodRepository.findById(periodId)
//                .orElseThrow(() -> new RuntimeException("Period not found"));
//
//        List<AccountBalance> balances =
//                balanceRepository.findAllByPeriodId(periodId);
//
//        // دسته بندی بر اساس AccountType
//        List<AccountBalance> assets = new ArrayList<>();
//        List<AccountBalance> liabilities = new ArrayList<>();
//        List<AccountBalance> equity = new ArrayList<>();
//
//        for (AccountBalance b : balances) {
//            AccountNature nature = b.getAccount().getAccountNature();
//            switch (nature) {
//                case AccountNature.ASSET -> assets.add(b);
//                case AccountNature.LIABILITY -> liabilities.add(b);
//                case AccountNature.EQUITY -> equity.add(b);
//                //REVENUE,EXPENSE در ترازنامه نمی ایند
//                default -> {}
//            }
//        }
//
//        BalanceSheetDto dto = new BalanceSheetDto();
//        dto.setPeriod(mapToPeriodTo(period));
//
//        dto.setSections(List.of(
//                buildSection("Assets", assets),
//                buildSection("Liabilities", liabilities),
//                buildSection("Equity", equity)
//        ));
//
//        dto.setTotalAssets(sumBalances(assets));
//        dto.setTotalLiabilities(sumBalances(liabilities));
//        dto.setTotalEquity(sumBalances(equity));
//
//        return dto;
//    }
//
//    private AccountingPeriodDto mapToPeriodTo(AccountingPeriod period){
//        AccountingPeriodDto periodDto = new AccountingPeriodDto();
//        periodDto.setPeriodNumber(period.getPeriodNumber());
//        periodDto.setFromDate(period.getFromDate());
//        periodDto.setToDate(period.getToDate());
//        periodDto.setIsClosed(period.getIsClosed());
//        return periodDto;
//    }
//
//    private BigDecimal sumBalances(List<AccountBalance> list) {
//        return list.stream()
//                .map(this::getClosingBalance)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }
//
//    private BalanceSheetSectionDto buildSection(String name, List<AccountBalance> list) {
//
//        List<AccountBalanceDTO> items = list.stream().map(b -> {
//            AccountBalanceDTO dto = new AccountBalanceDTO();
//            dto.setAccountCode(b.getAccount().getAccountCode());
//            dto.setAccountTitle(b.getAccount().getName());
//            //dto.setBalance(b.getClosingBalance());
//            return dto;
//        }).toList();
//
//        BigDecimal total = items.stream()
//                .map(AccountBalanceDTO::getBalance)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BalanceSheetSectionDto dto = new BalanceSheetSectionDto();
//        dto.setSectionName(name);
//        dto.setAccounts(items);
//        dto.setTotal(total);
//
//        return dto;
//    }
//
//    @Override
//    public ProfitAndLossDto getProfitAndLoss(Long periodId) {
//
//        AccountingPeriod period = periodRepository.findById(periodId)
//                .orElseThrow(() -> new RuntimeException("Period not found"));
//
//        List<AccountBalance> balances =
//                balanceRepository.findAllByPeriodId(periodId);
//
//        BigDecimal revenue = BigDecimal.ZERO;
//        BigDecimal expense = BigDecimal.ZERO;
//
//        for (AccountBalance b : balances) {
//            AccountNature nature = b.getAccount().getAccountNature();
//            AccountType type = b.getAccount().getAccountType();
//
//            switch (nature) {
//                case AccountNature.REVENUE -> revenue = revenue.add(getClosingBalance(b));
//                case AccountNature.EXPENSE -> expense = expense.add(getClosingBalance(b));
//                default -> {}
//            }
//        }
//
//        ProfitAndLossDto dto = new ProfitAndLossDto();
//        dto.setPeriod(mapToPeriodTo(period));
//        dto.setTotalRevenue(revenue);
//        dto.setTotalExpense(expense);
//        dto.setNetIncome(revenue.subtract(expense));
//
//        return dto;
//    }
//
//    private BigDecimal getClosingBalance(AccountBalance b) {
//        BigDecimal openning = b.getOpeningBalance() !=null ? b.getOpeningBalance() : BigDecimal.ZERO;
//        BigDecimal debit = b.getDebitTotal()!=null ? b.getDebitTotal() : BigDecimal.ZERO;
//        BigDecimal credit = b.getCreditTotal()!=null ? b.getCreditTotal() : BigDecimal.ZERO;
//
//        return openning.add(debit).subtract(credit);
//    }
//}
