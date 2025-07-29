package com.f2f.service;

import com.f2f.dto.OtherSellersDTO;
import com.f2f.repository.OtherSellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OtherSellersService {

    @Autowired
    OtherSellersRepository otherSellersRepository;

    public List<OtherSellersDTO> listOfSellersForThisProduct(Long aLong) {
        List<OtherSellersDTO> list = new ArrayList<OtherSellersDTO>();

        OtherSellersDTO l1 = new OtherSellersDTO();
        OtherSellersDTO l2 = new OtherSellersDTO();
        OtherSellersDTO l3 = new OtherSellersDTO();
        OtherSellersDTO l4 = new OtherSellersDTO();

        l1.setConditions("seller1");
        l1.setId(1);
        l1.setNameOfSeller("a");
        l1.setPromotions("pppppppp");
        l1.setImgUrl("\fff.jpg");
        l1.setPrice(String.valueOf(10));
        list.add(l1);

        l2.setConditions("seller2");
        l2.setId(2);
        l2.setNameOfSeller("a");
        l2.setPromotions("pppppppp");
        l2.setImgUrl("\fff.jpg");
        l2.setPrice(String.valueOf(10));
        list.add(l2);

        l3.setConditions("seller3");
        l3.setId(3);
        l3.setNameOfSeller("a");
        l3.setPromotions("pppppppp");
        l3.setImgUrl("\fff.jpg");
        l3.setPrice(String.valueOf(10));
        list.add(l3);

        l4.setConditions("seller4");
        l4.setId(4);
        l4.setNameOfSeller("a");
        l4.setPromotions("pppppppp");
        l4.setImgUrl("\fff.jpg");
        l4.setPrice(String.valueOf(10));
        list.add(l4);

        return list;

    }
}
