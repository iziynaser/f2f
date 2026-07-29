package com.f2f.repository;

import com.f2f.entity.AccountingChart;
import com.f2f.enums.AccountLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface AccountsChartRepository extends JpaRepository<AccountingChart, Long> {
    AccountingChart findByAccountCode(String code);

    List<AccountingChart> findByPostableTrue();

    List<AccountingChart> findByLevelIndex(int levelIndex);

    List<AccountingChart> findByAccountLevel(AccountLevel level);

    List<AccountingChart> findByParentAccount(AccountingChart parent);

    @Query("""
        select a from AccountingChart a 
        where lower(a.name) like lower(concat('%', :keyword, '%'))
           or lower(a.accountCode) like lower(concat('%', :keyword, '%'))
    """)
    List<AccountingChart> search(String keyword);

    List<AccountingChart> findByParentAccountId(Long parentId);

    @Query("SELECT a FROM AccountingChart a WHERE a.postable = true")
    List<AccountingChart> findPostableAccounts();

    boolean existsByAccountCode(String accountCode);

    List<AccountingChart> findByParentAccountIsNullOrderByAccountCodeAsc();
}


