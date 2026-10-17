package ir.verjik.controller;

import ir.verjik.dto.ProductKeywordDTO;
import ir.verjik.entity.Product;
import ir.verjik.entity.ProductKeyword;
import ir.verjik.service.ProductKeywordService;
import ir.verjik.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productKeywords")
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
        //ProductKeyword productKeyword = new ProductKeyword(product,dto.getKeyName(),dto.getKeyWeight(),dto.getKeyStatus());
        //ProductKeyword pKeyword = productKeywordService.save(productKeyword);

        //return pKeyword;
        return null;
    }
}
