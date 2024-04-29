package com.f2f.service;

import com.f2f.dao.product.OtherSellersDao;
import com.f2f.entity.product.OtherSellersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OtherSellersService {

    @Autowired
    OtherSellersDao otherSellersDao;

    public List<OtherSellersDTO> listOfSellersForThisProduct(Long aLong) {
        List<OtherSellersDTO> list = new ArrayList<OtherSellersDTO>();

        OtherSellersDTO l1 = new OtherSellersDTO();
        OtherSellersDTO l2 = new OtherSellersDTO();
        OtherSellersDTO l3 = new OtherSellersDTO();
        OtherSellersDTO l4 = new OtherSellersDTO();

        l1.setConditions("ccccccccccccc");
        l1.setId(1);
        l1.setNameOfSeller("a");
        l1.setPromotions("pppppppp");
        l1.setImgUrl("\fff.jpg");
        l1.setPrice(10);
        list.add(l1);

        l2.setConditions("ccccccccccccc");
        l2.setId(1);
        l2.setNameOfSeller("a");
        l2.setPromotions("pppppppp");
        l2.setImgUrl("\fff.jpg");
        l2.setPrice(10);
        list.add(l2);

        l3.setConditions("ccccccccccccc");
        l3.setId(1);
        l3.setNameOfSeller("a");
        l3.setPromotions("pppppppp");
        l3.setImgUrl("\fff.jpg");
        l3.setPrice(10);
        list.add(l3);

        l4.setConditions("ccccccccccccc");
        l4.setId(1);
        l4.setNameOfSeller("a");
        l4.setPromotions("pppppppp");
        l4.setImgUrl("\fff.jpg");
        l4.setPrice(10);
        list.add(l4);

        return list;

    }
}
