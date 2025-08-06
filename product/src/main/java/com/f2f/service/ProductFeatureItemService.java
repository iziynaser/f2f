package com.f2f.service;

import com.f2f.dto.ProductFeatureItemDTO;
import com.f2f.entity.ProductFeatureGroup;
import com.f2f.entity.ProductFeatureItem;
import com.f2f.mapper.ProductFeatureMapper;
import com.f2f.repository.ProductFeatureItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
