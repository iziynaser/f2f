package ir.verjik.port;

import ir.verjik.dto.ProductItemDTO;

import java.util.Optional;

public interface ProductItemPort {
    Optional<ProductItemDTO> findById(Long id);
}
