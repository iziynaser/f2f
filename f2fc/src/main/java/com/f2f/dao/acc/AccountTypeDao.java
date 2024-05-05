package com.f2f.dao.acc;

import com.f2f.entity.acc.AccountType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AccountTypeDao")
public interface AccountTypeDao extends CrudRepository<AccountType,Long>{

}
