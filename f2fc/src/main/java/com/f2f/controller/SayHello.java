package com.f2f.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/f2f")
public class SayHello {



    @GetMapping("/hi")
    public String findAll() {
        return "Hello f2f";
    }



}
