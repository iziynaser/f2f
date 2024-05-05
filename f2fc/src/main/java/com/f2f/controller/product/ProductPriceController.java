package com.f2f.controller.product;

import com.f2f.exceptions.F2fNotFoundException;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductPrice;
import com.f2f.entity.product.ProductPriceDTO;
import com.f2f.entity.product.ProductPriceType;
import com.f2f.service.product.ProductPriceService;
import com.f2f.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;

@RestController("ProductPriceController")
@RequestMapping("/f2f/ProductPrice")
public class ProductPriceController {

    @Autowired
    ProductPriceService productPriceService;

    @Autowired
    ProductService productService;

    //@Autowired
    //ProductPriceTypeService productPriceTypeService;

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductPrice createProductPrice(@RequestBody ProductPriceDTO productPriceDTO){

        Long productId = productPriceDTO.getProduct();
        Product product = productService.findProductById(productId);

        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(product);
        productPrice.setFromDate(productPriceDTO.getFromDate());
        productPrice.setToDate(productPriceDTO.getToDate());
        productPrice.setCurrency(productPriceDTO.getCurrency());
        productPrice.setTax(productPriceDTO.getTax());
        productPrice.setPrice(productPriceDTO.getPrice());

        //private ProductPriceType productPriceType;
        ProductPrice pp = productPriceService.save(productPrice);
        return pp;
    }

    //todo: productId must be optional ,if its true return all
    @GetMapping(value = "/list")
    public List<ProductPrice> getListOfProductPrice(@RequestParam(value = "productId", required = true) Long productId) {
        Product product = productService.findProductById(productId);
        if (product != null){
            List<ProductPrice> list = productPriceService.getListOfProductPrices(product);
            return list;
        }else{
            //todo: better handling with errcode,translation
            throw new F2fNotFoundException("record not found!s");
        }
    }


}
