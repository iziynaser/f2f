package com.f2f.adapter;

import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.entity.ProductCategories;
import com.f2f.mapper.ProductCategoriesMapper;
import com.f2f.port.ProductCategoriesPort;
import com.f2f.repository.ProductCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCategoriesAdapter implements ProductCategoriesPort {

    private final ProductCategoriesRepository productCategoriesRepository;
    private final ProductCategoriesMapper productCategoriesMapper;

    public ProductCategoriesAdapter(ProductCategoriesRepository productCategoriesRepository, ProductCategoriesMapper productCategoriesMapper) {
        this.productCategoriesRepository = productCategoriesRepository;
        this.productCategoriesMapper = productCategoriesMapper;
    }

    @Override
    public Optional<ProductCategoriesDTO> getPrimaryCategoryForProduct(Long productId) {
        ProductCategories entity = productCategoriesRepository.getFirstByProductIdAndIsPrimaryTrue(productId);
        return Optional.ofNullable(entity)
                .map(productCategoriesMapper::toDTO);
    }
}
