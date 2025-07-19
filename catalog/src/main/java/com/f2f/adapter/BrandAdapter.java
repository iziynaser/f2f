package com.f2f.adapter;

import com.f2f.dto.BrandDTO;
import com.f2f.mapper.BrandMapper;
import com.f2f.port.BrandPort;
import com.f2f.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandAdapter implements BrandPort {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandAdapter(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public Optional<BrandDTO> findById(Long id) {
        return brandRepository.findById(id)
                .map(brandMapper::toDto);
    }
}
