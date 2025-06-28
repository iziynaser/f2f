package com.f2f.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("HiProductController")
@RequestMapping("/product")
public class HiProductController {
    @GetMapping("/hi")
    public String getAccountList(){
        return "hi product";
    }
}
