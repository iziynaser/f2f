package com.f2f.controller;

import com.f2f.dto.ProductColorDTO;
import com.f2f.service.ProductColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController("ProductColorController")
@RequestMapping("/store/productColors")
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

//    @GetMapping("/products/{id}/colors")
//    public List<ProductColorDTO> getProductColors(@PathVariable Long id) {
//        // رنگ‌های محصول
//    }

}
