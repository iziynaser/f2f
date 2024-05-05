package com.f2f.dao.acc;

import com.f2f.entity.acc.AccountsChart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountsChartDao")
public interface AccountsChartDao extends CrudRepository<AccountsChart,Long> {
}
