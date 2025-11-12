package com.f2f.controller;

import com.f2f.entity.Category;
import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.entity.ProductCategories;
import com.f2f.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProductCategoriesController")
@RequestMapping("/productCategories")
public class ProductCategoriesController {

    private final ProductCategoriesService productCategoriesService ;

    public ProductCategoriesController(ProductCategoriesService productCategoriesService) {
        this.productCategoriesService = productCategoriesService;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductCategories createProductCategories(@RequestBody ProductCategoriesDTO productCategoriesDTO){
        Long categoryId = productCategoriesDTO.getCategoryId();
        String productId = productCategoriesDTO.getProductId().toString();
        return productCategoriesService.save(categoryId,Long.valueOf(productId));
    }

    @ResponseBody
    @GetMapping("/listOfCategoriesRelatedToProduct")
    public List<Category> getListOfCategoriesRelatedToThisProduct(@RequestParam(value = "productId") Long productId){
        List<Category> categoryList = productCategoriesService.getListOfCategoriesRelatedToThisProduct(productId);
        return categoryList;
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteProductFromThisCategory(@RequestParam(value = "categoryId")String categoryId,@RequestParam(value = "productId") String productId){
        productCategoriesService.deleteProductFromThisCategory(Long.valueOf(categoryId),Long.valueOf(productId));
        return "success" ;
    }

    @ResponseBody
    @GetMapping("/deleteAllProductsByCategoryId")
    public String deleteAllProductsByCategoryId(@RequestParam(value = "categoryId")String categoryId){
        productCategoriesService.deleteAllProductsByCategoryId(categoryId);
        return "success";
    }

}
