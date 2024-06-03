package com.f2f.dao.acc;

import com.f2f.entity.acc.AccountGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("AccountGroupDao")
@Repository
public interface AccountGroupDao extends CrudRepository<AccountGroup,Long> {

}
