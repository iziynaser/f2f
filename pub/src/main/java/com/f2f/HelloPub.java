package com.f2f;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloPub {
    @GetMapping("/helloPub")
    public String helloPub(){
        return "hello pub";
    }
}
