package com.f2f.dao;

import com.f2f.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PaymentDao")
@Repository
public interface PaymentDao extends CrudRepository<Payment,Long>{

}
