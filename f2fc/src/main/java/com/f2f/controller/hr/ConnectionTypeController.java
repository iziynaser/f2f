package com.f2f.controller.hr;

import com.f2f.entity.hr.ConnectionType;
import com.f2f.service.hr.ConnectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ConnectionTypeController")
@RequestMapping("/ConnectionType")
public class ConnectionTypeController{

    @Autowired
    ConnectionTypeService connectionTypeService;

    @GetMapping("/list")
    public List<ConnectionType> getConnectionTypeList(){
        List<ConnectionType> list = connectionTypeService.findAll();
        return list;
    }
}
