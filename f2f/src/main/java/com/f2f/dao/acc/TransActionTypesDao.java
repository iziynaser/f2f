package com.f2f.dao.acc;

import com.f2f.entity.acc.TransActionTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("TransActionTypesDao")
public interface TransActionTypesDao extends CrudRepository<TransActionTypes,Long>{

}
