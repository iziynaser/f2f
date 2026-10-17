package ir.verjik.repository;

import ir.verjik.entity.MeasureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureUnitRepository extends CrudRepository<MeasureUnit,Long>{

}
