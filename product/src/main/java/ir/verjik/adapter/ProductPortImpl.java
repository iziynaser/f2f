package ir.verjik.adapter;

import ir.verjik.dbc.dto.ProductDTO;
import ir.verjik.mapper.ProductMapper;
import ir.verjik.port.ProductPort;
import ir.verjik.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductPortImpl implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductPortImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO);
    }
}
