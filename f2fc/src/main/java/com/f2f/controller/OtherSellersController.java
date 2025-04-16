package com.f2f.controller;

import com.f2f.entity.common.KeyValues;
import com.f2f.entity.product.OtherSellersDTO;
import com.f2f.service.OtherSellersService;
import com.f2f.service.product.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("OtherSellersController")
@RequestMapping("/f2f/otherSellers")
public class OtherSellersController {

    @Autowired
    OtherSellersService otherSellersService;

    @Autowired
    PricingService pricingService ;

    @ResponseBody
    @GetMapping("/list")
    public List<OtherSellersDTO> getListOfProductsRelatedToThisCategory(@RequestParam(value = "productId") String productId){
        List<OtherSellersDTO> otherSellersDTOS = otherSellersService.listOfSellersForThisProduct(Long.valueOf(productId));
        return otherSellersDTOS;
    }

    @ResponseBody
    @GetMapping("/count")
    public KeyValues getOtherSellersCount(@RequestParam("productId") String productId){
        Integer count = 0;
        Long id = Long.valueOf(productId);
        count = pricingService.getCountOfOtherSellersOnProduct(id);
        KeyValues kv = new KeyValues("result",count);
        return  kv;
    }

}
