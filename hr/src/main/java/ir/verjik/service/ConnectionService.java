package ir.verjik.service;

import ir.verjik.dao.ConnectionDao;
import ir.verjik.entity.Connection;
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
