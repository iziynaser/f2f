package com.f2f.controller;

import com.f2f.entity.Ostan;
import com.f2f.service.OstanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/f2f/ostan")
@RequiredArgsConstructor
public class OstanController {

    private final OstanService ostanService;

    @GetMapping("/list")
    public List<Ostan> getInfo() {
        return ostanService.getInfo();
    }
}

