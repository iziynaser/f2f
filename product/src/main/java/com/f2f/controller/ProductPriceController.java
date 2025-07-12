package com.f2f.controller;

import com.f2f.dto.ProductPriceDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductPrice;
import com.f2f.exception.F2fNotFoundException;
import com.f2f.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("ProductPriceController")
@RequestMapping("/f2f/ProductPrice")
public class ProductPriceController {

    //private final ProductService productService;

    //@Autowired
    //ProductPriceTypeService productPriceTypeService;

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductPrice createProductPrice(@RequestBody ProductPriceDTO productPriceDTO){

        Long productId = productPriceDTO.getProduct();
        //Product product = productService.findProductById(productId);

        ProductPrice productPrice = new ProductPrice();
        //productPrice.setProduct(product);
        //productPrice.setFromDate(productPriceDTO.getFromDate());
        //productPrice.setToDate(productPriceDTO.getToDate());
        //productPrice.setCurrency(productPriceDTO.getCurrency());
        //productPrice.setTax(productPriceDTO.getTax());
        //productPrice.setPrice(productPriceDTO.getPrice());

        //private ProductPriceType productPriceType;
        ProductPrice pp = new ProductPrice();//productPriceService.save(productPrice);
        return pp;
    }

    //todo: productId must be optional ,if its true return all
    @GetMapping(value = "/list")
    public List<ProductPrice> getListOfProductPrice(@RequestParam(value = "productId", required = true) Long productId) {
        return null;
//        Product product = productService.findProductById(productId);
//        if (product != null){
//            List<ProductPrice> list = new ArrayList<>();//productPriceService.getListOfProductPrices(product);
//            return list;
//        }else{
//            //todo: better handling with errcode,translation
//            throw new F2fNotFoundException("record.not.found!s",null);
//        }
    }

//    @GetMapping("/products/{id}/prices")
//    public List<ProductPriceDTO> getProductPrices(@PathVariable Long id) {
//        // قیمت‌ها
//    }

}
