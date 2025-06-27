package com.f2f.service;

import com.f2f.dao.WorkSheetItemDao;
import com.f2f.entity.WorkSheetItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("WorkSheetItemService")
public class WorkSheetItemService{

    @Autowired
    WorkSheetItemDao workSheetItemDao;

    public List<WorkSheetItem> findAll() {
        return (List<WorkSheetItem>) workSheetItemDao.findAll();
    }
}
