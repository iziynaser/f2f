package com.f2f.controller;

import com.f2f.entity.product.OtherSellersDTO;
import com.f2f.entity.product.RelatedProductsDTO;
import com.f2f.service.OtherSellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("OtherSellersController")
@RequestMapping("/f2f/otherSellers")
public class OtherSellersController {

    @Autowired
    OtherSellersService otherSellersService;

    @ResponseBody
    @GetMapping("/list")
    public List<OtherSellersDTO> getListOfProductsRelatedToThisCategory(@RequestParam(value = "productId") String productId){
        List<OtherSellersDTO> otherSellersDTOS = otherSellersService.listOfSellersForThisProduct(Long.valueOf(productId));
        return otherSellersDTOS;
    }

}
