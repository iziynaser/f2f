package com.f2f.port;

import com.f2f.dto.ProductItemDTO;

import java.util.Optional;

public interface ProductItemPort {
    Optional<ProductItemDTO> findById(Long id);
}
