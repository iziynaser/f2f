package com.f2f.service;

import com.f2f.dto.RelatedProductsDTO;
import com.f2f.repository.RelatedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RelatedProductsService {

    @Autowired
    RelatedProductsRepository relatedProductsRepository;

    public List<RelatedProductsDTO> listOfRelatedProducts(Long productId) {
        //return relatedProductsDao.listOfRelatedProducts(productId);
        List<RelatedProductsDTO> relatedProductsDTOList = new ArrayList<>();

        RelatedProductsDTO r1 = new RelatedProductsDTO();
        r1.setName("aaaaaa");
        r1.setAmazingDesc("bbbbbbbbbbbb");
        r1.setPrice("12345");
        r1.setShortDesc("dd");
        r1.setImgUrl("\rr\rre.jpg");
        relatedProductsDTOList.add(r1);

        RelatedProductsDTO r2 = new RelatedProductsDTO();
        r2.setName("aaaaaa");
        r2.setAmazingDesc("bbbbbbbbbbbb");
        r2.setPrice("12345");
        r2.setShortDesc("dd");
        r2.setImgUrl("\rr\rre.jpg");
        relatedProductsDTOList.add(r2);

        RelatedProductsDTO r3 = new RelatedProductsDTO();
        r3.setName("aaaaaa");
        r3.setAmazingDesc("bbbbbbbbbbbb");
        r3.setPrice("12345");
        r3.setShortDesc("dd");
        r3.setImgUrl("\rr\rre.jpg");
        relatedProductsDTOList.add(r3);

        RelatedProductsDTO r4 = new RelatedProductsDTO();
        r4.setName("aaaaaa");
        r4.setAmazingDesc("bbbbbbbbbbbb");
        r4.setPrice("12345");
        r4.setShortDesc("dd");
        r4.setImgUrl("\rr\rre.jpg");
        relatedProductsDTOList.add(r4);

        return relatedProductsDTOList;
    }
}
