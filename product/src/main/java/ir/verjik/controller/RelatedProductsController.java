package ir.verjik.controller;

import ir.verjik.dto.RelatedProductsDTO;
import ir.verjik.service.RelatedProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController("RelatedProductsController")
@RequestMapping("/store/relatedProducts")
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
