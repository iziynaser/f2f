package com.f2f.service.hr;

import com.f2f.entity.hr.ConnectionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ConnectionTypeService")
public class ConnectionTypeService{
    public List<ConnectionType> findAll() {
        return null;
    }

    //@Autowired ConnectionTypeDao connectionTypeDao;
}
