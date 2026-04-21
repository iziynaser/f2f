package com.f2f.repository;

import com.f2f.entity.AccountsChart;
import com.f2f.entity.CustomerAccount;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountsChart, Long> {
    List<AccountsChart> findByParentAccountId(Long id);
}
