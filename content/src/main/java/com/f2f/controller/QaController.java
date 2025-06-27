package com.f2f.controller;

import com.f2f.dto.QaDTO;
import com.f2f.service.qa.QaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("QaController")
@RequestMapping("/f2f/qa")
public class QaController {
    @Autowired
    QaService qaService ;

    @ResponseBody
    @GetMapping("/ListOfQasForProductId")
    List<QaDTO> getListOfQasForProductId(@RequestParam("productId") String productId){
        long id = Long.parseLong(productId);
        List<QaDTO> list = qaService.getListOfQasForProductId(id);
        return list;
    }
}
