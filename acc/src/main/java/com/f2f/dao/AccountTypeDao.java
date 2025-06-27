package com.f2f.dao;

       
import com.f2f.entity.AccountType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountTypeDao")
@Repository
public interface AccountTypeDao extends CrudRepository<AccountType,Long>{

}
