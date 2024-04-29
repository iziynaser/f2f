package com.f2f.controller.product;

import com.f2f.entity.product.ProductType;
import com.f2f.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProductTypeController")
@RequestMapping("/f2f/ProductType")
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("/list")
    public List<ProductType> getProductTypeList(){
        List<ProductType> productTypes = productTypeService.findAll();
        return productTypes;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductType save(@RequestBody ProductType m){
        ProductType savedProductType = productTypeService.save(m);
        return savedProductType;
    }

    public void delete(ProductType m){
        productTypeService.delete(m);
    }
}
