package com.f2f.dao;

import com.f2f.entity.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeDao extends CrudRepository<PaymentType,Long>{

}
