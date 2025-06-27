package com.f2f.service;

import com.f2f.dao.ResumeDao;
import com.f2f.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ResumeService")
public class ResumeService{

    @Autowired
    ResumeDao resumeDao;

    public List<Resume> findAll() {
        return (List<Resume>) resumeDao.findAll();
    }
}
