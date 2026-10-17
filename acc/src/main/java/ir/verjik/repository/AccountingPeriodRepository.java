package ir.verjik.repository;

import ir.verjik.entity.AccountingPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface AccountingPeriodRepository extends JpaRepository<AccountingPeriod, Long> {


    @Query("""
        select p from AccountingPeriod p
        where :date between p.fromDate and p.toDate
    """)
    Optional<AccountingPeriod> findPeriodByDate(LocalDate date);


    Optional<AccountingPeriod>
    findFirstByCompanyIdAndBranchIdAndFiscalYearOrderByPeriodNumberAsc(
            Long companyId,
            Long branchId,
            Integer fiscalYear
    );

    Optional<AccountingPeriod> findFirstByCompanyIdAndBranchIdAndFiscalYearOrderByFromDateAsc(
            Long companyId,
            Long branchId,
            Integer fiscalYear
    );
}

