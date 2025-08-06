package com.f2f.service;

import com.f2f.dto.ProductFeatureValueDTO;
import com.f2f.entity.ProductFeatureItem;
import com.f2f.entity.ProductFeatureValue;
import com.f2f.mapper.ProductFeatureMapper;
import com.f2f.repository.ProductFeatureValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductFeatureValueService {

    private final ProductFeatureValueRepository valueRepository;
    private final ProductFeatureMapper mapper;

    // 1. ذخیره مقدار ویژگی اگر وجود نداشت
    public ProductFeatureValueDTO saveIfNotExists(ProductFeatureValue value, ProductFeatureItem item) {
        boolean exists = valueRepository.existsByNameAndFeatureItem(value.getName(), item);
        if (!exists) {
            value.setFeatureItem(item);
            ProductFeatureValue saved = valueRepository.save(value);
            return mapper.toValueDTO(saved);
        }
        return mapper.toValueDTO(value);
    }

    // 2. بارگذاری مقادیر یک آیتم
    public List<ProductFeatureValueDTO> loadValuesForItem(ProductFeatureItem item) {
        List<ProductFeatureValue> values = valueRepository.findByFeatureItemOrderByOrders(item);
        return values.stream()
                .map(mapper::toValueDTO)
                .collect(Collectors.toList());
    }
}
