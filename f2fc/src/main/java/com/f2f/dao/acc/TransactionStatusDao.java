package com.f2f.dao.acc;

import com.f2f.entity.acc.TransactionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("TransactionStatusDao")
public interface TransactionStatusDao extends CrudRepository<TransactionStatus,Long>{

}
