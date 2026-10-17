package ir.verjik.adapter;

import ir.verjik.dto.ProductCategoriesDTO;
import ir.verjik.mapper.ProductCategoriesMapper;
import ir.verjik.port.ProductCategoriesPort;
import ir.verjik.repository.ProductCategoriesRepository;
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
        return productCategoriesRepository.findPrimaryCategory(productId)
                .map(productCategoriesMapper::toDTO)
                .or(() -> productCategoriesRepository.findByProductId(productId).stream()
                        .findFirst()
                        .map(productCategoriesMapper::toDTO));
    }



}
