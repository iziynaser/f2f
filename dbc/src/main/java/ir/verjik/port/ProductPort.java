package ir.verjik.port;

import ir.verjik.dbc.dto.ProductDTO;

import java.util.Optional;

public interface ProductPort {
    Optional<ProductDTO> findById(Long id);
}