package com.f2f.dao.acc;

 
import com.f2f.entity.AccountingPeriod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountingPeriodDao")
@Repository
public interface AccountingPeriodDao extends CrudRepository<AccountingPeriod,Long>{

}
