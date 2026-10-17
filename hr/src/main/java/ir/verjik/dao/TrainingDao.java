package ir.verjik.dao;

import ir.verjik.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("TrainingDao")
@Repository
public interface TrainingDao extends CrudRepository<Training,Long> {

}
