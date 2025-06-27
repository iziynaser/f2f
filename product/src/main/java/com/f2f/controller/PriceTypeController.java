package com.f2f.controller;

import com.f2f.entity.PriceType;
import com.f2f.service.PriceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("PriceTypeController")
@RequestMapping("/f2f/priceType")
public class PriceTypeController {

    @Autowired
    PriceTypeService priceTypeService ;

    @GetMapping("/list")
    public List<PriceType> getPriceTypes(){
        List<PriceType> priceTypes = priceTypeService.findAll();
        return priceTypes;
    }

    @ResponseBody
    @PostMapping(value = "save")
    public PriceType save(@RequestBody PriceType p){
        PriceType returned = priceTypeService.save(p);
        return returned;
    }

}
