package com.f2f.dao.acc;

import com.f2f.entity.acc.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CurrencyDao")
public interface CurrencyDao extends CrudRepository<Currency,Long>{

}
