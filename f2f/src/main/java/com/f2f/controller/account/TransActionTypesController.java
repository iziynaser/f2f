package com.f2f.controller.account;

import com.f2f.entity.acc.TransActionTypes;
import com.f2f.service.account.TransActionTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TransActionTypesController")
@RequestMapping("/TransActionTypes")
public class TransActionTypesController {

    @Autowired
    TransActionTypesService transActionTypesService;

    @GetMapping("/list")
    public List<TransActionTypes> getTransActionTypesList(){
        return transActionTypesService.findAll();
    }

}
