package com.f2f.controller;

import com.f2f.entity.Position;
import com.f2f.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PositionController")
@RequestMapping("/Position")
public class PositionController{

    @Autowired
    PositionService positionService;

    @GetMapping("/list")
    public List<Position> getPositionList(){
        List<Position> list = positionService.findAll();
        return list;
    }
}
