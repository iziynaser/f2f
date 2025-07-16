package com.f2f.adapter;

import com.f2f.dao.ProductRepository;
import com.f2f.dto.ProductDTO;
import com.f2f.mapper.ProductMapper;
import com.f2f.port.ProductPort;
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
