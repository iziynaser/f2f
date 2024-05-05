package com.f2f.service.hr;

import com.f2f.dao.hr.WorkSheetDao;
import com.f2f.entity.hr.WorkSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("WorkSheetService")
public class WorkSheetService{

    @Autowired
    WorkSheetDao workSheetDao;

    public List<WorkSheet> findAll() {
        return (List<WorkSheet>) workSheetDao.findAll();
    }
}
