package com.f2f.repository;

import com.f2f.entity.AccountsChart;
import com.f2f.enums.AccountLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface AccountsChartRepository extends JpaRepository<AccountsChart, Long> {
    AccountsChart findByAccountCode(String code);

    List<AccountsChart> findByPostableTrue();

    List<AccountsChart> findByLevelIndex(int levelIndex);

    List<AccountsChart> findByAccountLevel(AccountLevel level);

    List<AccountsChart> findByParentAccount(AccountsChart parent);

    @Query("""
        select a from AccountsChart a 
        where lower(a.name) like lower(concat('%', :keyword, '%'))
           or lower(a.accountCode) like lower(concat('%', :keyword, '%'))
    """)
    List<AccountsChart> search(String keyword);

    List<AccountsChart> findByParentAccountId(Long parentId);

    @Query("SELECT a FROM AccountsChart a WHERE a.postable = true")
    List<AccountsChart> findPostableAccounts();

    boolean existsByAccountCode(String accountCode);

    List<AccountsChart> findByParentAccountIsNullOrderByAccountCodeAsc();
}


