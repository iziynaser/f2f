package com.f2f.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DefaultConfig")
@RequestMapping("/DefaultConfig")
public class DefaultConfig {

    @GetMapping("/sql")
    public void runDefualtDataAtStartup(){
        
    }
}
