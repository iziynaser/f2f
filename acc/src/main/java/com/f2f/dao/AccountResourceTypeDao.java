package com.f2f.dao;

import com.f2f.entity.AccountResourceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountResourceTypeDao")
@Repository
public interface AccountResourceTypeDao extends CrudRepository<AccountResourceType,Long>{

}
