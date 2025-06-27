package com.f2f.dao;

import com.f2f.entity.TransActionTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("TransActionTypesDao")
@Repository
public interface TransActionTypesDao extends CrudRepository<TransActionTypes,Long>{

}
