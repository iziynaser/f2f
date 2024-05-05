package com.f2f.service.hr;

import com.f2f.dao.hr.ResumeDao;
import com.f2f.entity.hr.Resume;
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
