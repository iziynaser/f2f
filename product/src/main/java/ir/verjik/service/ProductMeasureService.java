package ir.verjik.service;

import ir.verjik.dbc.domain.EntityNotFoundException;
import ir.verjik.entity.Product;
import ir.verjik.entity.ProductMeasure;
import ir.verjik.repository.ProductMeasureRepository;
import ir.verjik.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductMeasureService {

    @Autowired
    ProductMeasureRepository productMeasureRepository;

    @Autowired
    ProductRepository productDao;

    public ProductMeasure save(ProductMeasure productMeasure){
        ProductMeasure feature = productMeasureRepository.save(productMeasure);
        return feature;
    }

    public ProductMeasure load(String productId) {
        ProductMeasure pm;
        Optional<Product> optionalProduct = productDao.findById(Long.valueOf(productId));
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);

        pm = productMeasureRepository.findAllByProduct(product);

        return pm;
    }
}
