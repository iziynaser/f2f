package com.f2f.controller;

import com.f2f.dbc.dto.NameValueDTO;
import com.f2f.dto.ProductDTO;
import com.f2f.entity.Product;
import com.f2f.service.CommentLikeSummaryService;
import com.f2f.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProductController")
@RequestMapping("/f2f/products")
public class ProductController {

    private final ProductService productService;

    private final CommentLikeSummaryService commentLikeSummaryService;

    public ProductController(ProductService productService, CommentLikeSummaryService commentLikeSummaryService) {
        this.productService = productService;
        this.commentLikeSummaryService = commentLikeSummaryService;
    }

    @GetMapping("/list")
    public List<ProductDTO> getProducts(){
        List<ProductDTO> list = productService.findAllAvailableProducts();
        return list;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public Product createProduct(@RequestBody Product product){
        Product p = productService.save(product);
        //F2fSuccessResponse response = new F2fSuccessResponse.F2fSuccessBuilder().withBody(p).build();
        //return new ResponseEntity<F2fSuccessResponse>(response,HttpStatus.OK);
        return p;
    }

    @ResponseBody
    @GetMapping("/loadProductMainPart/")
    public Product findProductMainPartWithId(@RequestParam("productId") String productId){
            Long id = Long.valueOf(productId);
            Product product = productService.findProductMainPartWithId(id);
            return product;
    }

    @ResponseBody
    @GetMapping("/nameValue")
    public List<NameValueDTO> getNameValuesOfProducts(){
        List<NameValueDTO> result = productService.getNameValuesOfProducts();
        return result;
    }

    @GetMapping("/countCommentsForProduct")
    public int getNumberOfCommentsForProduct(@RequestParam("productId") String productId){
        return 40;
//        KeyValues kv = new KeyValues("result","0");
//        return kv;
    }

    @GetMapping("/countViewsForProduct")
    public int getNumberOfViewsForProduct(@RequestParam("productId") String productId){
        return 10;
//        KeyValues kv = new KeyValues("result","0");
//        return kv;
    }

    @GetMapping("/countRemainStoreForProduct")
    public int getNumberOfRemainProductsInStore(@RequestParam("productId") String productId){
        return 20;
//        KeyValues kv = new KeyValues("result","0");
//        return kv;
    }

    @GetMapping("/countStarsForProduct")
    public int getNumberOfStarsForProduct(@RequestParam("productId") String productId){
        return 30;
//        KeyValues kv = new KeyValues("result","0");
//        return kv;
    }

}

