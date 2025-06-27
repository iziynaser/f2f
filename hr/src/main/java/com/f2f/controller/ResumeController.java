package com.f2f.controller;

import com.f2f.entity.Resume;
import com.f2f.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ResumeController")
@RequestMapping("/Resume")
public class ResumeController{

    @Autowired
    ResumeService resumeService;

    @GetMapping("/list")
    public List<Resume> getResumeList(){
        List<Resume> list = resumeService.findAll();
        return list;
    }
}
