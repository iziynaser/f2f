package com.f2f.service;

import com.f2f.dao.WorkSheetDao;
import com.f2f.entity.WorkSheet;
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
