package com.f2f.service.account;

import com.f2f.dao.acc.TransActionTypesDao;
import com.f2f.entity.acc.TransActionTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("TransActionTypesService")
public class TransActionTypesService {

    @Autowired
    TransActionTypesDao transActionTypesDao;

    public List<TransActionTypes> findAll() {
        return(List<TransActionTypes>) transActionTypesDao.findAll();
    }
}
