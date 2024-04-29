package com.f2f.controller.hr;

import com.f2f.entity.hr.WorkSheetItem;
import com.f2f.service.hr.WorkSheetItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("WorkSheetItemController")
@RequestMapping("/WorkSheetItem")
public class WorkSheetItemController{

    @Autowired
    WorkSheetItemService workSheetItemService;

    @GetMapping("/list")
    public List<WorkSheetItem> getWorkSheetItemList(){
        List<WorkSheetItem> list = workSheetItemService.findAll();
        return list;
    }
}
