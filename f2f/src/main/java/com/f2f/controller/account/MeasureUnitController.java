package com.f2f.controller.account;

import com.f2f.entity.acc.MeasureUnit;
import com.f2f.service.account.MeasureUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("MeasureUnitController")
@RequestMapping("/MeasureUnit")
public class MeasureUnitController {

    @Autowired
    MeasureUnitService measureUnitService;

    @GetMapping("/list")
    public List<MeasureUnit> getMeasureUnitList(){
        return measureUnitService.findAll();
    }

}
