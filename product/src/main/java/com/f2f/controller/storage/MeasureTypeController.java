package com.f2f.controller.storage;

import com.f2f.entity.MeasureUnit;
import com.f2f.service.MeasureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("MeasureTypeController")
@RequestMapping("/MeasureType")
public class MeasureTypeController {

    @Autowired
    MeasureTypeService measureTypeService;

    @GetMapping("/list")
    public List<MeasureUnit> getMeasureUnits(){
        List<MeasureUnit> list = measureTypeService.findAll();
        return list;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public MeasureUnit save(@RequestBody MeasureUnit m){
        MeasureUnit savedUnit = measureTypeService.save(m);
        return savedUnit;
    }

    public void delete(MeasureUnit m){
        measureTypeService.delete(m);
    }

}
