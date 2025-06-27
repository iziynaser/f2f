package com.f2f.dao;

import com.f2f.entity.AccountsChart;
import org.springframework.data.repository.CrudRepository;

//@Repository("AccountsChartDao")
public interface AccountsChartDao extends CrudRepository<AccountsChart,Long> {
}
