package com.f2f.adapter;

import com.f2f.dto.ProductItemDTO;
import com.f2f.mapper.ProductItemMapper;
import com.f2f.port.ProductItemPort;
import com.f2f.repository.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductItemPortImpl implements ProductItemPort {

    private final ProductItemRepository productItemRepository;
    private final ProductItemMapper productItemMapper;

    public ProductItemPortImpl(ProductItemRepository productItemRepository, ProductItemMapper productItemMapper) {
        this.productItemRepository = productItemRepository;
        this.productItemMapper = productItemMapper;
    }

    @Override
    public Optional<ProductItemDTO> findById(Long id) {
        return productItemRepository.findById(id)
                .map(productItemMapper::toDTO);
    }
}
