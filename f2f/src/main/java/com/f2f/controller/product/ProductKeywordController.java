package com.f2f.controller.product;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductKeyword;
import com.f2f.entity.product.ProductKeywordDTO;
import com.f2f.service.product.ProductKeywordService;
import com.f2f.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/f2f/productKeywords")
public class ProductKeywordController {

    @Autowired
    private ProductKeywordService productKeywordService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductKeyword> findAllByProductId(Long productId){
        List<ProductKeyword> productKeywords = productKeywordService.findAllByProduct(productId);
        return productKeywords;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductKeyword createProductKeyword(@RequestBody ProductKeywordDTO dto){

        Product product = productService.findProductById(dto.getProduct());
        ProductKeyword productKeyword = new ProductKeyword(product,dto.getKeyName(),dto.getKeyWeight(),dto.getKeyStatus());
        ProductKeyword pKeyword = productKeywordService.save(productKeyword);

        return pKeyword;
    }
}
