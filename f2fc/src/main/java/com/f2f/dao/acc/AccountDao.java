package com.f2f.dao.acc;


import com.f2f.entity.acc.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AccountDao")
public interface AccountDao extends CrudRepository<Account,Long> {
}
