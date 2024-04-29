package com.f2f.front.controller;

import com.f2f.entity.common.KeyValues;
import com.f2f.entity.common.ProductColorDTO;
import com.f2f.entity.product.ProductColor;
import com.f2f.front.service.product.ProductColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProductColorController")
@RequestMapping("/f2f/productColors")
public class ProductColorController {

    @Autowired
    ProductColorService productColorService;

   @GetMapping("/list")
   @ResponseBody
   public List<ProductColorDTO> ListOfProductColors(@RequestParam("productId") String productId){
       Long id = Long.valueOf(productId);
       List<ProductColorDTO> productColorList = productColorService.getListOfProductColors(id);
       return  productColorList;
   }

}
