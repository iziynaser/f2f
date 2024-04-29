package com.f2f.dao.acc;

import com.f2f.entity.acc.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PaymentDao")
public interface PaymentDao extends CrudRepository<Payment,Long>{

}
