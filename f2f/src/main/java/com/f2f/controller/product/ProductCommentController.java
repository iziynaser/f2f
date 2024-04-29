package com.f2f.controller.product;

import com.f2f.service.product.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ProductCommentController")
@RequestMapping("/f2f/productComments")
public class ProductCommentController {

    @Autowired
    ProductCommentService productCommentService;

    @ResponseBody
    @GetMapping("/numberOfCommentsForProduct")
    String getNumberOfCommentsForProduct(@RequestParam("productId") String productId){
        int count = 0;
        Long id = Long.valueOf(productId);
        count = productCommentService.getNumberOfCommentsOnProduct(id);
        return String.valueOf(count) ;
    }

}
