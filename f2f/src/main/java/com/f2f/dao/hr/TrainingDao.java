package com.f2f.dao.hr;

import com.f2f.entity.hr.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("TrainingDao")
public interface TrainingDao extends CrudRepository<Training,Long> {

}
