package com.f2f.repository;

import com.f2f.dto.TransactionDTO;
import com.f2f.dto.TransactionDetailDTO;
import com.f2f.dto.TransactionSearchFilter;
import com.f2f.dto.TransactionSummaryDTO;
import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingTransaction;
import com.f2f.enums.DebitCreditType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.criteria.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountingTransactionQueryRepositoryImpl implements AccountingTransactionQueryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<TransactionSummaryDTO> search(TransactionSearchFilter filter, Pageable pageable) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<TransactionSummaryDTO> cq = cb.createQuery(TransactionSummaryDTO.class);
        Root<AccountingTransaction> root = cq.from(AccountingTransaction.class);

        Join<AccountingTransaction, AccountTransactionDetail> details =
                root.join("accountTransactionDetails", JoinType.LEFT);

        // CASE expressions for debit/credit
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

        cq.select(
                cb.construct(
                        TransactionSummaryDTO.class,
                        root.get("id"),
                        root.get("transactionNumber"),
                        root.get("transactionDate"),
                        root.get("description"),
                        root.get("transactionStatus"),
                        debitExpr,
                        creditExpr
                )
        );

        List<Predicate> predicates = new ArrayList<>();

        if (filter.number() != null)
            predicates.add(cb.equal(root.get("transactionNumber"), filter.number()));

        if (filter.from() != null)
            predicates.add(cb.greaterThanOrEqualTo(root.get("transactionDate"), filter.from()));

        if (filter.to() != null)
            predicates.add(cb.lessThanOrEqualTo(root.get("transactionDate"), filter.to()));

        if (filter.periodId() != null)
            predicates.add(cb.equal(root.get("accountingPeriod").get("id"), filter.periodId()));

        if (filter.status() != null)
            predicates.add(cb.equal(root.get("transactionStatus"), filter.status()));

        if (filter.accountId() != null)
            predicates.add(cb.equal(details.get("accountsChart").get("id"), filter.accountId()));

        if (filter.minAmount() != null)
            predicates.add(cb.greaterThanOrEqualTo(details.get("amountFunctional"), filter.minAmount()));

        if (filter.maxAmount() != null)
            predicates.add(cb.lessThanOrEqualTo(details.get("amountFunctional"), filter.maxAmount()));

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        cq.groupBy(
                root.get("id"),
                root.get("transactionNumber"),
                root.get("transactionDate"),
                root.get("description"),
                root.get("transactionStatus")
        );

        cq.orderBy(cb.desc(root.get("transactionDate")));

        TypedQuery<TransactionSummaryDTO> query = em.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<TransactionSummaryDTO> list = query.getResultList();

        // COUNT QUERY
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

    // -----------------------------------------------------------------
    //   FIND DETAILED TRANSACTION
    // -----------------------------------------------------------------
    @Override
    public TransactionDTO findDetailedById(Long id) {

        AccountingTransaction tx = em.find(AccountingTransaction.class, id);
        if (tx == null) return null;

        List<TransactionDetailDTO> details = tx.getAccountTransactionDetails().stream()
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
                details
        );
    }
}
