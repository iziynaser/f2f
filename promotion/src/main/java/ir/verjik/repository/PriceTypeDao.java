package ir.verjik.repository;

import ir.verjik.entity.PriceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTypeDao extends CrudRepository<PriceType,Long> {

}
