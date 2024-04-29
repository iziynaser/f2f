package com.f2f.controller.product;

import com.f2f.entity.common.PriceType;
import com.f2f.service.product.PriceTypeService;
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
