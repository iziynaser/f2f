package com.f2f.repository;

import com.f2f.entity.MeasureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureTypeRepository extends CrudRepository<MeasureUnit,Long> {

}
