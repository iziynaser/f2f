package ir.verjik.adapter;

import ir.verjik.dto.BrandDTO;
import ir.verjik.mapper.BrandMapper;
import ir.verjik.port.BrandPort;
import ir.verjik.repository.BrandRepository;
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
