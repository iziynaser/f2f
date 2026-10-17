package ir.verjik.controller;

import ir.verjik.entity.WorkSheet;
import ir.verjik.service.WorkSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("WorkSheetController")
@RequestMapping("/WorkSheet")
public class WorkSheetController{

    @Autowired
    WorkSheetService workSheetService;

    @GetMapping("/list")
    public List<WorkSheet> getWorkSheetList(){
        List<WorkSheet> list = workSheetService.findAll();
        return list;
    }
}
