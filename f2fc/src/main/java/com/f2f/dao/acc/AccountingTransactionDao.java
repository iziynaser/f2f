package com.f2f.dao.acc;

import com.f2f.entity.acc.AccountingTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountingTransactionDao")
@Repository
public interface AccountingTransactionDao extends CrudRepository<AccountingTransaction,InternalError>{

}
