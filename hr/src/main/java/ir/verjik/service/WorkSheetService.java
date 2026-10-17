package ir.verjik.service;

import ir.verjik.dao.WorkSheetDao;
import ir.verjik.entity.WorkSheet;
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
