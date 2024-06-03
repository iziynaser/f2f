package com.f2f.dao.acc;

import com.f2f.entity.acc.TransactionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("TransactionDetailDao")
@Repository
public interface TransactionDetailDao extends CrudRepository<TransactionDetail,Long>{

}
