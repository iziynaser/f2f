package com.f2f.dao.acc;

import com.f2f.entity.acc.Cash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CashDao")
public interface CashDao extends CrudRepository<Cash,Long>{


}
