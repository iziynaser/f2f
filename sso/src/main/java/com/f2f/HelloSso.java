package com.f2f;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSso {

    @GetMapping("/helloSso")
    public String helloSso(){
        return "hello sso";
    }
}
