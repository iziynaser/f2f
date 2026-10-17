package ir.verjik.service;

import ir.verjik.dao.WorkSheetItemDao;
import ir.verjik.entity.WorkSheetItem;
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
