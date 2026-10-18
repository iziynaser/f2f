package ir.verjik.repository;


import ir.verjik.dto.*;
import ir.verjik.entity.AccountTransactionDetail;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.enums.DebitCreditType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountingTransactionRepositoryImpl
        implements AccountingTransactionCustomRepository {

    @PersistenceContext
    private EntityManager em;

    // =====================================================================
    // 1) SEARCH (Criteria API)
    // =====================================================================
    @Override
    public Page<TransactionSummaryDTO> search(TransactionSearchFilter filter, Pageable pageable) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<TransactionSummaryDTO> cq = cb.createQuery(TransactionSummaryDTO.class);
        Root<AccountingTransaction> root = cq.from(AccountingTransaction.class);

        Join<AccountingTransaction, AccountTransactionDetail> details =
                root.join("accountTransactionDetails", JoinType.LEFT);

        // CASE expressions
        Expression<BigDecimal> debitExpr =
                cb.sum(
                        cb.<BigDecimal>selectCase()
                                .when(cb.equal(details.get("debitCreditType"), DebitCreditType.DEBIT),
                                        details.get("amountFunctional"))
                                .otherwise(BigDecimal.ZERO)
                );

        Expression<BigDecimal> creditExpr =
                cb.sum(
                        cb.<BigDecimal>selectCase()
                                .when(cb.equal(details.get("debitCreditType"), DebitCreditType.CREDIT),
                                        details.get("amountFunctional"))
                                .otherwise(BigDecimal.ZERO)
                );

        cq.select(cb.construct(
                TransactionSummaryDTO.class,
                root.get("id"),
                root.get("transactionNumber"),
                root.get("transactionDate"),
                root.get("description"),
                root.get("transactionStatus"),
                debitExpr,
                creditExpr
        ));

        List<Predicate> preds = new ArrayList<>();

        if (filter.number() != null)
            preds.add(cb.equal(root.get("transactionNumber"), filter.number()));

        if (filter.from() != null)
            preds.add(cb.greaterThanOrEqualTo(root.get("transactionDate"), filter.from()));

        if (filter.to() != null)
            preds.add(cb.lessThanOrEqualTo(root.get("transactionDate"), filter.to()));

        if (filter.periodId() != null)
            preds.add(cb.equal(root.get("accountingPeriod").get("id"), filter.periodId()));

        if (filter.status() != null)
            preds.add(cb.equal(root.get("transactionStatus"), filter.status()));

        if (filter.accountId() != null)
            preds.add(cb.equal(details.get("accountingChart").get("id"), filter.accountId()));

        if (filter.minAmount() != null)
            preds.add(cb.greaterThanOrEqualTo(details.get("amountFunctional"), filter.minAmount()));

        if (filter.maxAmount() != null)
            preds.add(cb.lessThanOrEqualTo(details.get("amountFunctional"), filter.maxAmount()));

        cq.where(cb.and(preds.toArray(new Predicate[0])));

        cq.groupBy(
                root.get("id"),
                root.get("transactionNumber"),
                root.get("transactionDate"),
                root.get("description"),
                root.get("transactionStatus")
        );

        cq.orderBy(cb.desc(root.get("transactionDate")));

        TypedQuery<TransactionSummaryDTO> q = em.createQuery(cq);
        q.setFirstResult((int) pageable.getOffset());
        q.setMaxResults(pageable.getPageSize());

        List<TransactionSummaryDTO> list = q.getResultList();

        // COUNT
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<AccountingTransaction> countRoot = countQuery.from(AccountingTransaction.class);
        countQuery.select(cb.countDistinct(countRoot));

        List<Predicate> countPreds = new ArrayList<>();

        if (filter.number() != null)
            countPreds.add(cb.equal(countRoot.get("transactionNumber"), filter.number()));

        if (filter.from() != null)
            countPreds.add(cb.greaterThanOrEqualTo(countRoot.get("transactionDate"), filter.from()));

        if (filter.to() != null)
            countPreds.add(cb.lessThanOrEqualTo(countRoot.get("transactionDate"), filter.to()));

        if (filter.periodId() != null)
            countPreds.add(cb.equal(countRoot.get("accountingPeriod").get("id"), filter.periodId()));

        if (filter.status() != null)
            countPreds.add(cb.equal(countRoot.get("transactionStatus"), filter.status()));

        countQuery.where(cb.and(countPreds.toArray(new Predicate[0])));

        Long total = em.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(list, pageable, total);
    }

    // =====================================================================
    // 2) FIND DETAILED TRANSACTION
    // =====================================================================
    @Override
    public TransactionDTO findDetailedById(Long id) {

        AccountingTransaction tx = em.find(AccountingTransaction.class, id);
        if (tx == null) return null;

        List<TransactionDetailDTO> detailDTOs =
                tx.getAccountTransactionDetails().stream()
                        .map(d -> new TransactionDetailDTO(
                                d.getAccountingChart().getId(),
                                d.getAccountingChart().getId().toString(),
                                d.getAccountingChart().getAccountCode(),
                                d.getAccountingChart().getName(),
                                d.getDebitCreditType() == DebitCreditType.DEBIT ? d.getAmountFunctional() : BigDecimal.ZERO,
                                d.getDebitCreditType() == DebitCreditType.CREDIT ? d.getAmountFunctional() : BigDecimal.ZERO
                        ))
                        .toList();

        return new TransactionDTO(
                tx.getId(),
                tx.getTransactionNumber(),
                tx.getTransactionDate(),
                tx.getDescription(),
                tx.getTransactionStatus(),
                detailDTOs
        );
    }

    // =====================================================================
    // 3) FIND JOURNAL (Entities)
    // =====================================================================
    @Override
    public List<AccountingTransaction> findJournal(JournalFilter f) {

        String jpql = """
            select distinct t
            from AccountingTransaction t
            left join fetch t.accountTransactionDetails d
            left join fetch d.accountingChart a
            where (:from is null or t.transactionDate >= :from)
              and (:to is null or t.transactionDate <= :to)
              and (:accId is null or a.id = :accId)
              and (:periodId is null or t.accountingPeriod.id = :periodId)
              and (:fy is null or t.accountingPeriod.fiscalYear = :fy)
              and (:num is null or t.transactionNumber = :num)
              and (:status is null or t.transactionStatus = :status)
            order by t.transactionDate asc, t.transactionNumber asc
        """;

        TypedQuery<AccountingTransaction> q = em.createQuery(jpql, AccountingTransaction.class);
        q.setParameter("from", f.getFromDate());
        q.setParameter("to", f.getToDate());
        q.setParameter("accId", f.getAccountId());
        //q.setParameter("periodId", f.fiscalPeriodId());
        //q.setParameter("fy", f.fiscalYear());
        //q.setParameter("num", f.voucherNumber());
        //q.setParameter("status", f.status());

        return q.getResultList();
    }

    // =====================================================================
    // 4) FIND JOURNAL ENTRIES (DTO)
    // =====================================================================
    @Override
    public List<JournalEntryDTO> findJournalEntries(JournalFilter f) {

        String jpql = """
            select new ir.verjik.dto.JournalEntryDTO(
                t.id,
                t.transactionNumber,
                t.transactionDate,
                t.description,
                d.id,
                a.id,
                a.accountCode,
                a.accountName,
                case when d.debitCreditType = ir.verjik.enums.DebitCreditType.DEBIT
                     then d.amountFunctional else 0 end,
                case when d.debitCreditType = ir.verjik.enums.DebitCreditType.CREDIT
                     then d.amountFunctional else 0 end
            )
            from AccountingTransaction t
            join t.accountTransactionDetails d
            join d.accountingChart a
            where (:from is null or t.transactionDate >= :from)
              and (:to is null or t.transactionDate <= :to)
              and (:accId is null or a.id = :accId)
              and (:periodId is null or t.accountingPeriod.id = :periodId)
              and (:fy is null or t.accountingPeriod.fiscalYear = :fy)
              and (:num is null or t.transactionNumber = :num)
              and (:status is null or t.transactionStatus = :status)
            order by t.transactionDate asc, t.transactionNumber asc, d.id asc
        """;

        TypedQuery<JournalEntryDTO> q = em.createQuery(jpql, JournalEntryDTO.class);
        q.setParameter("from", f.getFromDate());
        q.setParameter("to", f.getToDate());
        q.setParameter("accId", f.getAccountId());
        //q.setParameter("periodId", f.fiscalPeriodId());
        //q.setParameter("fy", f.fiscalYear());
        //q.setParameter("num", f.voucherNumber());
        //q.setParameter("status", f.status());

        return q.getResultList();
    }

    @Override
    public Optional<BigDecimal> sumBalanceBefore(Long accountId, LocalDate beforeDate) {

        String jpql = """
        select coalesce(
               sum(case when d.debitCreditType = ir.verjik.enums.DebitCreditType.DEBIT
                        then d.amountFunctional else 0 end)
               -
               sum(case when d.debitCreditType = ir.verjik.enums.DebitCreditType.CREDIT
                        then d.amountFunctional else 0 end)
        , 0)
        from AccountTransactionDetail d
        join d.accountingTransaction t
        where d.accountingChart.id = :accId
          and t.transactionDate < :before
    """;

        BigDecimal result = em.createQuery(jpql, BigDecimal.class)
                .setParameter("accId", accountId)
                .setParameter("before", beforeDate)
                .getSingleResult();

        return Optional.ofNullable(result);
    }
    @Override
    public Optional<BigDecimal> sumDebitBetween(Long accountId, LocalDate from, LocalDate to) {

        String jpql = """
        select coalesce(sum(d.amountFunctional), 0)
        from AccountTransactionDetail d
        join d.accountingTransaction t
        where d.accountingChart.id = :accId
          and t.transactionDate between :from and :to
          and d.debitCreditType = ir.verjik.enums.DebitCreditType.DEBIT
    """;

        BigDecimal result = em.createQuery(jpql, BigDecimal.class)
                .setParameter("accId", accountId)
                .setParameter("from", from)
                .setParameter("to", to)
                .getSingleResult();

        return Optional.ofNullable(result);
    }
}
