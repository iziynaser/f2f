package ir.verjik.service;

import ir.verjik.dao.ResumeDao;
import ir.verjik.entity.Resume;
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
