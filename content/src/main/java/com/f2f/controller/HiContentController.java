package com.f2f.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController("HiContentController")
@RequestMapping("/content")
public class HiContentController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hi")
    public String getAccountList(Locale locale) {
        return messageSource.getMessage("greeting",null,locale);
    }
}
