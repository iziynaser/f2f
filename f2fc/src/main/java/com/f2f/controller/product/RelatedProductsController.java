package com.f2f.controller.product;

import com.f2f.entity.product.ProductCategoriesDTO;
import com.f2f.entity.product.RelatedProductsDTO;
import com.f2f.service.RelatedProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("RelatedProductsController")
@RequestMapping("/f2f/relatedProducts")
public class RelatedProductsController {

    @Autowired
    RelatedProductsService relatedProductsService;

    @ResponseBody
    @GetMapping("/list")
    public List<RelatedProductsDTO> getListOfProductsRelatedToThisCategory(@RequestParam(value = "productId") String productId){
        List<RelatedProductsDTO> productCategoriesDTOS = relatedProductsService.listOfRelatedProducts(Long.valueOf(productId));
        return productCategoriesDTOS;
    }
}
