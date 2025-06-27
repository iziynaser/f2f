package com.f2f.dao;

import com.f2f.entity.TransactionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("TransactionStatusDao")
@Repository
public interface TransactionStatusDao extends CrudRepository<TransactionStatus,Long>{

}
