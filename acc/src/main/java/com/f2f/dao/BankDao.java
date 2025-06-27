package com.f2f.dao;

import com.f2f.entity.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("BankDao")
@Repository
public interface BankDao extends CrudRepository<Bank,Long>{

}
