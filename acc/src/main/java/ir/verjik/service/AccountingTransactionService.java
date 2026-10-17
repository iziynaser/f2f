package ir.verjik.service;

import com.f2f.dto.*;
import ir.verjik.dto.*;
import ir.verjik.dto.chartOfAccount.CreateTransactionRequest;
import ir.verjik.dto.transactions.AccountingTransactionResponseDto;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.enums.TransactionStatus;
import ir.verjik.mapper.AccountingTransactionMapper;
import ir.verjik.repository.AccountingTransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountingTransactionService {

    private final TransactionNumberGeneratorService numberGenerator;
    private final TransactionFactoryService factoryService;
    private final TransactionLifecycleManagerService lifecycleService;
    private final AccountingTransactionRepository txRepo;
    private final AccountingTransactionMapper mapper;

    public AccountingTransactionService(
            TransactionNumberGeneratorService numberGenerator,
            TransactionFactoryService factoryService,
            TransactionLifecycleManagerService lifecycleService,
            AccountingTransactionRepository txRepo,
            AccountingTransactionMapper mapper) {

        this.numberGenerator = numberGenerator;
        this.factoryService = factoryService;
        this.lifecycleService = lifecycleService;
        this.txRepo = txRepo;
        this.mapper = mapper;
    }

    public AccountingTransactionResponseDto createTransaction(CreateTransactionRequest req) {

        AccountingTransactionResponseDto tx =
                factoryService.createDraft(req, numberGenerator.generate());

        return tx;
    }

    public AccountingTransaction post(Long id) {

        AccountingTransaction tx = findOrThrow(id);

        lifecycleService.changeStatus(tx, TransactionStatus.POSTED);

        return txRepo.save(tx);
    }

    public AccountingTransaction lock(Long id) {

        AccountingTransaction tx = findOrThrow(id);

        lifecycleService.changeStatus(tx, TransactionStatus.LOCKED);

        return txRepo.save(tx);
    }

    public AccountingTransaction cancel(Long id) {

        AccountingTransaction tx = findOrThrow(id);

        lifecycleService.changeStatus(tx, TransactionStatus.CANCELLED);

        return txRepo.save(tx);
    }

    public AccountingTransaction reverse(Long id) {

        AccountingTransaction tx = findOrThrow(id);

        lifecycleService.changeStatus(tx, TransactionStatus.REVERSED);

        return txRepo.save(tx);
    }

    public Optional<AccountingTransaction> getById(Long id) {
        return txRepo.findById(id);
    }

    public AccountingTransaction update(Long id, CreateTransactionRequest req) {

        AccountingTransaction tx = findOrThrow(id);

        if (tx.getTransactionStatus() != TransactionStatus.DRAFT) {
            throw new RuntimeException("Only DRAFT transaction can be edited");
        }

        //factoryService.updateDraft(tx, req);

        return txRepo.save(tx);
    }

    public void delete(Long id) {

        AccountingTransaction tx = findOrThrow(id);

        if (tx.getTransactionStatus() != TransactionStatus.DRAFT &&
                tx.getTransactionStatus() != TransactionStatus.CANCELLED) {

            throw new RuntimeException("Only DRAFT or CANCELLED transactions can be deleted");
        }

        txRepo.delete(tx);
    }

    public Page<TransactionSummaryDTO> searchTransactions(
            TransactionSearchFilter filter,
            Pageable pageable) {

        return txRepo.search(filter, pageable);
    }

    public TransactionDTO getTransaction(Long id) {

        TransactionDTO dto = txRepo.findDetailedById(id);

        if (dto == null) {
            throw new RuntimeException("Transaction not found");
        }

        return dto;
    }

    public List<JournalEntryDTO> getJournal(JournalFilter filter) {

        return txRepo.findJournalEntries(filter);
    }

    private AccountingTransaction findOrThrow(Long id) {

        return txRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
