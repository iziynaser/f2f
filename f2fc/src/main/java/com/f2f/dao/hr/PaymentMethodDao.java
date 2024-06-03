package com.f2f.dao.hr;

import com.f2f.entity.hr.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PaymentMethodDao")
@Repository
public interface PaymentMethodDao extends CrudRepository<PaymentMethod,Long> {
}
