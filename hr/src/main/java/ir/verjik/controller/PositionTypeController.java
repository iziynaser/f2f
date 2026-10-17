package ir.verjik.controller;

import ir.verjik.entity.PositionType;
import ir.verjik.service.PositionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PositionTypeController")
@RequestMapping("/PositionType")
public class PositionTypeController{

    @Autowired
    PositionTypeService positionTypeService;

    @GetMapping("/list")
    public List<PositionType> getPositionTypeList(){
        List<PositionType> list = positionTypeService.findAll();
        return list;
    }

}
