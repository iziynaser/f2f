package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.dto.ProductDTO;
import com.f2f.entity.Category;
import com.f2f.entity.ProductCategories;
import com.f2f.mapper.ProductCategoriesMapper;
import com.f2f.port.ProductPort;
import com.f2f.repository.CategoryRepository;
import com.f2f.repository.ProductCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoriesService {

    private final ProductCategoriesRepository productCategoriesRepository;
    private final CategoryRepository categoryRepository;
    private final ProductPort productPort;
    private final ProductCategoriesMapper productCategoriesMapper;

    public ProductCategoriesService(ProductCategoriesRepository productCategoriesRepository,
                                    CategoryRepository categoryRepository,
                                    ProductPort productPort, ProductCategoriesMapper productCategoriesMapper) {
        this.productCategoriesRepository = productCategoriesRepository;
        this.categoryRepository = categoryRepository;
        this.productPort = productPort;
        this.productCategoriesMapper = productCategoriesMapper;
    }

    public ProductCategories save(Long categoryId, Long productId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(EntityNotFoundException::new);

        ProductDTO product = productPort.findById(productId)
                .orElseThrow(EntityNotFoundException::new);

        ProductCategories productCategories = new ProductCategories();
        productCategories.setProductId(Long.valueOf(product.getId()));
        productCategories.setCategory(category);

        return productCategoriesRepository.save(productCategories);
    }

    public List<ProductCategoriesDTO> listOfProductsRelatedToThisCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(EntityNotFoundException::new);

        return productCategoriesRepository.listOfProductsRelatedToThiscategory(category);
    }

    public List<Category> getListOfCategoriesRelatedToThisProduct(Long productId) {
        ProductDTO product = productPort.findById(productId)
                .orElseThrow(EntityNotFoundException::new);

        return productCategoriesRepository.getListOfCategoriesRelatedToProduct(Long.valueOf(product.getId()));
    }

    public void deleteProductFromThisCategory(Long categoryId, Long productId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(EntityNotFoundException::new);

        productPort.findById(productId)
                .orElseThrow(EntityNotFoundException::new);

        ProductCategories productCategories =
                productCategoriesRepository.getFirstByCategoryIdAndProductId(categoryId, productId);

        if (productCategories != null) {
            productCategoriesRepository.delete(productCategories);
        }
    }

    public Optional<ProductCategoriesDTO> getPrimaryCategoryForProduct(Long productId) {
        return productCategoriesRepository.findPrimaryCategory(productId)
                .map(productCategoriesMapper::toDTO)
                .or(() -> productCategoriesRepository.findByProductId(productId).stream()
                        .findFirst()
                        .map(productCategoriesMapper::toDTO));
    }



    public void deleteAllProductsByCategoryId(String categoryId) {
        // قابل پیاده‌سازی در صورت وجود نیاز
    }
}
