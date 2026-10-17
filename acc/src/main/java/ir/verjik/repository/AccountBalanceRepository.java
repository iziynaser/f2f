package ir.verjik.repository;

import ir.verjik.entity.AccountBalance;
import ir.verjik.entity.AccountingPeriod;
import ir.verjik.entity.AccountingChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {

    List<AccountBalance> findAllByPeriodId(Long periodId);

    @Query("""
        select b 
        from AccountBalance b 
        where b.account.id = :accountId 
          and b.period.id = :periodId
    """)
    Optional<AccountBalance> findByAccountIdAndPeriodId(Long accountId, Long periodId);

    @Query("""
        select b 
        from AccountBalance b 
        where b.period.id = :periodId
    """)
    List<AccountBalance> findByPeriod(Long periodId);


    @Query("""
        select b
        from AccountBalance b
        where b.period.id = (
            select p.id
            from AccountingPeriod p
            where p.fiscalYear = :fiscalYear
              and p.companyId = :companyId
              and p.branchId = :branchId
              and p.periodNumber = (
                    select max(p2.periodNumber)
                    from AccountingPeriod p2
                    where p2.fiscalYear = :fiscalYear
                      and p2.companyId = :companyId
                      and p2.branchId = :branchId
              )
        )
    """)
    List<AccountBalance> findYearClosingBalances(
            Integer fiscalYear,
            Long companyId,
            Long branchId
    );


    @Query("""
    select b
    from AccountBalance b
    where b.period.id = (
        select p.id
        from AccountingPeriod p
        where p.fiscalYear = :fiscalYear
          and p.companyId = :companyId
          and p.branchId = :branchId
          and p.periodNumber = (
                select max(p2.periodNumber)
                from AccountingPeriod p2
                where p2.fiscalYear = :fiscalYear
                  and p2.companyId = :companyId
                  and p2.branchId = :branchId
          )
    )
""")
    List<AccountBalance> findYearBalances(
            Integer fiscalYear,
            Long companyId,
            Long branchId
    );


    @Query("""
    select b.openingBalance
    from AccountBalance b
    where b.account.id = :accountId
      and b.period = (
         select p
         from AccountingPeriod p
         where :date between p.fromDate and p.toDate
      )
""")
    Optional<BigDecimal> findOpeningBalance(Long accountId, LocalDate date);


    Optional<AccountBalance> findByAccountAndPeriod(AccountingChart acc, AccountingPeriod period);

    List<AccountBalance> findAllByPeriod(AccountingPeriod period);

    // temporary accounts (Revenue / Expense)
    @Query("""
        select b
        from AccountBalance b
        join b.account a
        where b.period.id = :periodId
          and a.accountNature in (com.f2f.enums.AccountNature.REVENUE, com.f2f.enums.AccountNature.EXPENSE)
          and (b.openingBalance + b.debitTotal - b.creditTotal) <> 0
    """)
    List<AccountBalance> findTemporaryAccounts(Long periodId);


    @Query("""
        select (b.openingBalance + b.debitTotal - b.creditTotal)
        from AccountBalance b
        where b.account.id = :accountId
          and b.period.id = :periodId
    """)
    Optional<BigDecimal> findClosingBalance(Long accountId, Long periodId);
}

