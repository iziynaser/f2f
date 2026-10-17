package ir.verjik.service;

import ir.verjik.repository.PriceTypeDao;
import ir.verjik.entity.PriceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceTypeService {

    @Autowired
    PriceTypeDao priceTypeDao;

    public List<PriceType> findAll(){
        List<PriceType> priceType = (List<PriceType>) priceTypeDao.findAll();
        return priceType;
    }

    public PriceType save(PriceType p) {
        PriceType r = priceTypeDao.save(p);
        return r;
    }
}
