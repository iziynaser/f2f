package com.f2f.controller.product;

import com.exceptions.F2fNotFoundException;
import com.f2f.entity.acc.MeasureUnit;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductMeasure;
import com.f2f.entity.product.ProductMeasureDTO;
import com.f2f.service.account.MeasureUnitService;
import com.f2f.service.product.ProductMeasureService;
import com.f2f.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f2f/productMeasure")
public class ProductMeasureController {

    @Autowired
    ProductMeasureService productMeasureService ;

    @Autowired
    ProductService productService;

    @Autowired
    MeasureUnitService measureUnitService;

    @ResponseBody
    @PostMapping(value = "/save")
    public ProductMeasure createProductMeasure(@RequestBody ProductMeasureDTO productMeasureDTO){

        MeasureUnit widthType = measureUnitService.findById(productMeasureDTO.getWidthType());//.orElseThrow(F2fNotFoundException::new);
        MeasureUnit heightype = measureUnitService.findById(productMeasureDTO.getHeightType());//.orElseThrow(F2fNotFoundException::new);
        MeasureUnit weightType = measureUnitService.findById(productMeasureDTO.getWeightType());//.orElseThrow(F2fNotFoundException::new);
        MeasureUnit depthType = measureUnitService.findById(productMeasureDTO.getDepthType());//.orElseThrow(F2fNotFoundException::new);

        Product product = productService.findProductById(productMeasureDTO.getProduct());
        ProductMeasure productMeasure = new ProductMeasure();
        productMeasure.setProduct(product);
        productMeasure.setDepthType(depthType);
        productMeasure.setHeightType(heightype);
        productMeasure.setWeightType(weightType);
        productMeasure.setWidthType(widthType);

        ProductMeasure productMeasure1 = productMeasureService.save(productMeasure);
        return productMeasure1;
    }

    @ResponseBody
    @GetMapping("/load")
    public ProductMeasure load(@RequestParam("productId") String productId){
        ProductMeasure pm = productMeasureService.load(productId);
        return pm;
    }
}
