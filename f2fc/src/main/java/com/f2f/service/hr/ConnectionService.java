package com.f2f.service.hr;

import com.f2f.dao.hr.ConnectionDao;
import com.f2f.entity.hr.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ConnectionService")
public class ConnectionService{

    @Autowired
    ConnectionDao connectionDao;

    public List<Connection> findAll() {
        return (List<Connection>) connectionDao.findAll();
    }
}
