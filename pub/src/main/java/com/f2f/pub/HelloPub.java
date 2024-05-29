package com.f2f.pub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloPub {
    @GetMapping("/pub/hi")
    public String helloPub(){
        return "hello pub";
    }
}
