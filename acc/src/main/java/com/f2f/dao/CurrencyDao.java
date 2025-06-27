package com.f2f.dao;

import com.f2f.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("CurrencyDao")
@Repository
public interface CurrencyDao extends CrudRepository<Currency,Long>{

}
