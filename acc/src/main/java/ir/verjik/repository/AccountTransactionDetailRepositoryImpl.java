package ir.verjik.repository;

import ir.verjik.entity.AccountTransactionDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountTransactionDetailRepositoryImpl implements AccountTransactionDetailRepositoryCustom {

    @PersistenceContext
    private EntityManager em;



//    @Query("""
//       select td
//       from AccountTransactionDetail td
//       join fetch td.accountingTransaction t
//       join fetch td.accountingChart a
//       where t.transactionStatus = enums.ir.verjik.TransactionStatus.POSTED
//         and a.id = :accountId
//         and t.accountingPeriod.id = :periodId
//       order by t.transactionDate asc, t.id asc
//    """)
//    List<AccountTransactionDetail> findPostedByAccountAndPeriod(Long accountId, Long periodId);



//    @Query("""
//       select td
//       from AccountTransactionDetail td
//       join fetch td.accountingTransaction t
//       join fetch td.accountingChart a
//       where t.transactionStatus = enums.ir.verjik.TransactionStatus.POSTED
//         and t.accountingPeriod.id = :periodId
//       order by a.accountCode asc, t.transactionDate asc, t.id asc
//    """)
//    List<AccountTransactionDetail> findGeneralLedgerForPeriod(Long periodId);



//    @Query("""
//       select td
//       from AccountTransactionDetail td
//       join fetch td.accountingTransaction t
//       join fetch td.accountingChart a
//       where t.transactionStatus = enums.ir.verjik.TransactionStatus.POSTED
//         and t.accountingPeriod.id = :periodId
//    """)
//    List<AccountTransactionDetail> findAllPostedForTrialBalance(Long periodId);



//    @Query("""
//       select d
//       from AccountTransactionDetail d
//       join fetch d.accountingChart a
//       join fetch d.accountingTransaction t
//       where (:#{#f.accountId} is null or a.id = :#{#f.accountId})
//         and (:#{#f.fromDate} is null or t.transactionDate >= :#{#f.fromDate})
//         and (:#{#f.toDate} is null or t.transactionDate <= :#{#f.toDate})
//         and (:#{#f.fiscalPeriodId} is null or t.accountingPeriod.id = :#{#f.fiscalPeriodId})
//         and (:#{#f.fiscalYear} is null or t.accountingPeriod.fiscalYear = :#{#f.fiscalYear})
//       order by t.transactionDate asc, t.transactionNumber asc
//    """)
//    List<AccountTransactionDetail> findLedgerLines(@Param("f") LedgerFilter filter);


    // -------------------------------------------------------------
    //    مجموع بدهکار در بازه تاریخی
    // -------------------------------------------------------------
    @Override
    public Optional<BigDecimal> sumDebitInDateRange(Long accountId, LocalDate from, LocalDate to) {

        String jpql =
                """
                SELECT COALESCE(
                           SUM(
                               CASE WHEN d.debitCreditType = com.yourpackage.DebitCreditType.DEBIT
                                    THEN d.amountFunctional
                                    ELSE 0
                               END
                           ), 0)
                FROM AccountTransactionDetail d
                JOIN d.accountingTransaction t
                WHERE d.accountingChart.id = :accId
                  AND t.transactionDate >= :from
                  AND t.transactionDate <= :to
                  AND t.transactionStatus = ir.verjik.enums.TransactionStatus.POSTED
                """;

        BigDecimal result = em.createQuery(jpql, BigDecimal.class)
                .setParameter("accId", accountId)
                .setParameter("from", from)
                .setParameter("to", to)
                .getSingleResult();

        return Optional.of(result);
    }

    // -------------------------------------------------------------
    //    مجموع بستانکار در بازه تاریخی
    // -------------------------------------------------------------
    @Override
    public Optional<BigDecimal> sumCreditInDateRange(Long accountId, LocalDate from, LocalDate to) {

        String jpql =
                """
                SELECT COALESCE(
                           SUM(
                               CASE WHEN d.debitCreditType = com.yourpackage.DebitCreditType.CREDIT
                                    THEN d.amountFunctional
                                    ELSE 0
                               END
                           ), 0)
                FROM AccountTransactionDetail d
                JOIN d.accountingTransaction t
                WHERE d.accountingChart.id = :accId
                  AND t.transactionDate >= :from
                  AND t.transactionDate <= :to
                  AND t.transactionStatus = ir.verjik.enums.TransactionStatus.POSTED
                """;

        BigDecimal result = em.createQuery(jpql, BigDecimal.class)
                .setParameter("accId", accountId)
                .setParameter("from", from)
                .setParameter("to", to)
                .getSingleResult();

        return Optional.of(result);
    }

    // -------------------------------------------------------------
    //    مجموع مانده قبل از تاریخ شروع (Opening)
    // -------------------------------------------------------------
    @Override
    public Optional<BigDecimal> sumOpeningBefore(Long accountId, LocalDate beforeDate) {

        String jpql =
                """
                SELECT COALESCE(
                           SUM(
                               CASE WHEN d.debitCreditType = com.yourpackage.DebitCreditType.DEBIT
                                    THEN d.amountFunctional
                                    ELSE -d.amountFunctional
                               END
                           ), 0)
                FROM AccountTransactionDetail d
                JOIN d.accountingTransaction t
                WHERE d.accountingChart.id = :accId
                  AND t.transactionDate < :beforeDate
                  AND t.transactionStatus = ir.verjik.enums.TransactionStatus.POSTED
                """;

        BigDecimal result = em.createQuery(jpql, BigDecimal.class)
                .setParameter("accId", accountId)
                .setParameter("beforeDate", beforeDate)
                .getSingleResult();

        return Optional.of(result);
    }

    @Override
    public List<AccountTransactionDetail> findPostedByAccountAndPeriod(Long accountId, Long periodId) {
        return List.of();
    }

    @Override
    public List<AccountTransactionDetail> findGeneralLedgerForPeriod(Long periodId) {
        return List.of();
    }

    @Override
    public List<AccountTransactionDetail> findAllPostedForTrialBalance(Long periodId) {
        return List.of();
    }

    @Override
    public Optional<BigDecimal> sumCreditBetween(Long accountId, LocalDate from, LocalDate to) {

        String jpql = """
        select coalesce(sum(d.amountFunctional), 0)
        from AccountTransactionDetail d
        join d.accountingTransaction t
        where d.accountingChart.id = :accId
          and t.transactionDate between :from and :to
          and d.debitCreditType = ir.verjik.enums.DebitCreditType.CREDIT
    """;

        BigDecimal result = em.createQuery(jpql, BigDecimal.class)
                .setParameter("accId", accountId)
                .setParameter("from", from)
                .setParameter("to", to)
                .getSingleResult();

        return Optional.ofNullable(result);
    }

}
