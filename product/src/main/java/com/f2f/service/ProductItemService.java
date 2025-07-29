package com.f2f.service;

import com.f2f.entity.ProductItem;
import com.f2f.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductItemService {

    @Autowired
    private ProductItemRepository repository;

    List<ProductItem> findProductItemByProductId(Long productId){
        return repository.findProductItemByProductId(productId);
    }

    public Optional<ProductItem> findMainItemForProduct(Long productId) {
        List<ProductItem> items = repository.findProductItemsByProductIdSorted(productId);
        return items.stream().findFirst();
    }

}
