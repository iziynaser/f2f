package com.f2f.dao.acc;

import com.f2f.entity.acc.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PaymentTypeDao")
public interface PaymentTypeDao extends CrudRepository<PaymentType,Long>{

}
