package com.f2f.service.qa;

import com.f2f.dao.qa.QaDao;
import com.f2f.dto.QaDTO;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@PreAuthorize("isAuthenticated()")
public class QaService {
    @Autowired
    QaDao qaDao ;

//    List<QaDTO> getListOfQasForThisProductId(Long productId){
//        List<QaDTO> listOfQsRelatedToThisProduct = new ArrayList<>();
//        List<Qa> listOfQa = qaDao.findAll();
//        for(Qa question : listOfQa){
//            if (question.getProduct().getId()==productId){
//                //listOfQsRelatedToThisProduct.add();
//            }
//        }
//        return listOfQsRelatedToThisProduct;
//    }

    public List<QaDTO> getListOfQasForProductId(long productId) {
        List<QaDTO> list = qaDao.getListOfQasForProductId(productId);
        return list;
    }
}
