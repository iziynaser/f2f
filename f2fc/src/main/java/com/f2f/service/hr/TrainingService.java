package com.f2f.service.hr;

import com.f2f.dao.hr.TrainingDao;
import com.f2f.entity.hr.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("TrainingService")
public class TrainingService{

    @Autowired
    TrainingDao trainingDao;

    public List<Training> findAll() {
        return (List<Training>) trainingDao.findAll();
    }
}
