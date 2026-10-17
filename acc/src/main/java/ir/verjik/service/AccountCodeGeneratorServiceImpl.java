package ir.verjik.service;

import ir.verjik.entity.AccountingChart;
import ir.verjik.repository.AccountsChartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountCodeGeneratorServiceImpl implements AccountCodeGeneratorService {

    private final AccountsChartRepository accountRepository;

    public AccountCodeGeneratorServiceImpl(AccountsChartRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String generateChildCode(AccountingChart parent) {

        List<AccountingChart> children =
                accountRepository.findByParentAccountId(parent.getId());

        children.sort(Comparator.comparing(AccountingChart::getAccountCode));

        if (children.isEmpty()) {
            return parent.getAccountCode() + "01";
        }

        String lastCode = children.get(children.size() - 1).getAccountCode();

        String lastTwoDigits = lastCode.substring(lastCode.length() - 2);
        int next = Integer.parseInt(lastTwoDigits) + 1;

        return parent.getAccountCode() + String.format("%02d", next);
    }

}

