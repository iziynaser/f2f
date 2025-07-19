package com.f2f.port;

import com.f2f.dto.BrandDTO;

import java.util.Optional;

public interface BrandPort {
    Optional<BrandDTO> findById(Long id);
}
