package ir.verjik.service;

import ir.verjik.dto.ProductFeatureItemDTO;
import ir.verjik.entity.ProductFeatureGroup;
import ir.verjik.entity.ProductFeatureItem;
import ir.verjik.mapper.ProductFeatureMapper;
import ir.verjik.repository.ProductFeatureItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductFeatureItemService {

    private final ProductFeatureItemRepository itemRepository;
    private final ProductFeatureMapper mapper;

    // 1. ذخیره آیتم اگر وجود نداشت (بر اساس name)
    public ProductFeatureItemDTO saveIfNotExists(ProductFeatureItem item, ProductFeatureGroup group) {
        boolean exists = itemRepository.existsByNameAndFeatureGroup(item.getName(), group);
        if (!exists) {
            item.setFeatureGroup(group);
            ProductFeatureItem saved = itemRepository.save(item);
            return mapper.toItemDTO(saved);
        }
        return mapper.toItemDTO(item);
    }

    // 2. بارگذاری آیتم‌های یک گروه
    public List<ProductFeatureItemDTO> loadItemsForGroup(ProductFeatureGroup group) {
        List<ProductFeatureItem> items = itemRepository.findByFeatureGroup_IdOrderByOrders(group.getId());
        return items.stream()
                .map(mapper::toItemDTO)
                .collect(Collectors.toList());
    }
}
