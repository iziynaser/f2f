package com.f2f.dao.acc;

import com.f2f.entity.acc.AccountResourceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AccountResourceTypeDao")
public interface AccountResourceTypeDao extends CrudRepository<AccountResourceType,Long>{

}
