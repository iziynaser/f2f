package ir.verjik.port;

import ir.verjik.dto.BrandDTO;

import java.util.Optional;

public interface BrandPort {
    Optional<BrandDTO> findById(Long id);
}
