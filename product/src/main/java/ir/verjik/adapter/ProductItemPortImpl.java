package ir.verjik.adapter;

import ir.verjik.dto.ProductItemDTO;
import ir.verjik.mapper.ProductItemMapper;
import ir.verjik.port.ProductItemPort;
import ir.verjik.repository.ProductItemRepository;
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
