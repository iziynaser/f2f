package ir.verjik.controller;

import ir.verjik.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ProductCommentController")
@RequestMapping("/productComments")
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
