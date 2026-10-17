package ir.verjik.dao;

import ir.verjik.entity.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PaymentMethodDao")
@Repository
public interface PaymentMethodDao extends CrudRepository<PaymentMethod,Long> {
}
