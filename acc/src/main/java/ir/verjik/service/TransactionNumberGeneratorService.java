package ir.verjik.service;

import ir.verjik.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionNumberGeneratorService {

    private final NumberSequenceService numberSequenceService;
    private final AccountingTransactionRepository repository;

    public TransactionNumberGeneratorService(AccountingTransactionRepository repository, NumberSequenceService numberSequenceService) {
        this.repository = repository;
        this.numberSequenceService = numberSequenceService;
    }

    @Transactional
    public Long generate() {

        Long max = numberSequenceService.next("TX");

        if (max == null)
            return 1L;

        return max ;
    }
}
