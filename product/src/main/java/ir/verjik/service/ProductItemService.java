package ir.verjik.service;

import ir.verjik.entity.ProductItem;
import ir.verjik.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
