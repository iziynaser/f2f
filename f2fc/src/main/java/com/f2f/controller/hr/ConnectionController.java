package com.f2f.controller.hr;

import com.f2f.entity.hr.Connection;
import com.f2f.service.hr.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ConnectionController")
@RequestMapping("/Connection")
public class ConnectionController{

    @Autowired
    ConnectionService connectionService ;

    @GetMapping("/list")
    public List<Connection> getConnectionList(){
        List<Connection> list = connectionService.findAll();
        return list;
    }
}
