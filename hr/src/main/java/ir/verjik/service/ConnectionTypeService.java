package ir.verjik.service;

import ir.verjik.entity.ConnectionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ConnectionTypeService")
public class ConnectionTypeService{
    public List<ConnectionType> findAll() {
        return null;
    }

    //@Autowired ConnectionTypeDao connectionTypeDao;
}
