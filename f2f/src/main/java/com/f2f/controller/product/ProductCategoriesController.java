package com.f2f.controller.product;

import com.f2f.entity.common.Category;
import com.f2f.entity.product.ProductCategories;
import com.f2f.entity.product.ProductCategoriesDTO;
import com.f2f.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProductCategoriesController")
@RequestMapping("/f2f/productCategories")
public class ProductCategoriesController {

    @Autowired
    ProductCategoriesService productCategoriesService ;

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductCategories createProductCategories(@RequestBody ProductCategoriesDTO productCategoriesDTO){
        Long categoryId = productCategoriesDTO.getCategoryId();
        String productId = productCategoriesDTO.getProductId();
        return productCategoriesService.save(categoryId,Long.valueOf(productId));
    }

    @ResponseBody
    @GetMapping("/list")
    public List<ProductCategoriesDTO> getListOfProductsRelatedToThisCategory(@RequestParam(value = "categoryId") String categoryId){
        List<ProductCategoriesDTO> productCategoriesDTOS = productCategoriesService.listOfProductsRelatedToThiscategory(Long.valueOf(categoryId));
        return productCategoriesDTOS;
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
