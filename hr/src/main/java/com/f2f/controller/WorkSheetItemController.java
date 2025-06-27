package com.f2f.controller;

import com.f2f.entity.WorkSheetItem;
import com.f2f.service.WorkSheetItemService;
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
