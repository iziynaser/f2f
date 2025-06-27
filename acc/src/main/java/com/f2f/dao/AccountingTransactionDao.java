package com.f2f.dao;

import com.f2f.entity.AccountingTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountingTransactionDao")
@Repository
public interface AccountingTransactionDao extends CrudRepository<AccountingTransaction,InternalError>{

}
