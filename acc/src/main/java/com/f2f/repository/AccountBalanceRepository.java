package com.f2f.repository;


import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountingPeriod;
import com.f2f.entity.AccountsChart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {
    //Optional<AccountBalance> findByAccountAndPeriod(AccountsChart acc, AccountingPeriod period);
}
