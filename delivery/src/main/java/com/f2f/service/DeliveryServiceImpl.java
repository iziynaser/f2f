package com.f2f.service;

import com.f2f.dto.DeliveryDTO;
import com.f2f.entity.Delivery;
import com.f2f.enums.DeliveryStatus;
import com.f2f.mapper.DeliveryMapper;
import com.f2f.repository.DeliveryRepository;
import com.f2f.repository.OstanRepository;
import com.f2f.repository.ShahrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final OstanRepository ostanRepository;
    private final ShahrRepository shahrRepository;
    private final DeliveryMapper deliveryMapper;

    @Override
    public DeliveryDTO createDelivery(DeliveryDTO dto) {
        Delivery delivery = deliveryMapper.toEntity(dto);
        delivery.setActive(true);
        delivery.setDeliveryStatus(DeliveryStatus.PENDING);
        //delivery.setCreatedAt(LocalDateTime.now());
        Delivery saved = deliveryRepository.save(delivery);
        return deliveryMapper.toDTO(saved);
    }

    @Override
    public DeliveryDTO updateDelivery(Long id, DeliveryDTO dto) {
        Delivery existing = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));

        if (!existing.getUserAccountId().equals(dto.getUserAccountId())) {
            throw new SecurityException("Access denied to this delivery");
        }

        Delivery updated = deliveryMapper.toEntity(dto);
        updated.setId(id);
        //updated.setCreatedAt(existing.getCreatedAt());
        updated.setActive(existing.isActive());
        Delivery saved = deliveryRepository.save(updated);
        return deliveryMapper.toDTO(saved);
    }

    @Override
    public void deleteDelivery(Long id, Long userAccountId) {
        Delivery delivery = deliveryRepository.findByIdAndUserAccountId(id, userAccountId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setActive(false);
        deliveryRepository.save(delivery);
    }

    @Override
    public DeliveryDTO getDeliveryById(Long id, Long userAccountId) {
        Delivery delivery = deliveryRepository.findByIdAndUserAccountId(id, userAccountId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        return deliveryMapper.toDTO(delivery);
    }

    @Override
    public List<DeliveryDTO> getAllDeliveriesForUser(Long userAccountId) {
        List<Delivery> deliveries = deliveryRepository.findAllByUserAccountIdAndIsActiveTrue(userAccountId);
        return deliveries.stream().map(deliveryMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void setDefaultDelivery(Long id, Long userAccountId) {
        // غیر فعال کردن آدرس پیش‌فرض قبلی
        deliveryRepository.findFirstByUserAccountIdAndIsDefaultTrue(userAccountId)
                .ifPresent(delivery -> {
                    delivery.setDefault(false);
                    deliveryRepository.save(delivery);
                });

        // فعال کردن آدرس جدید به عنوان پیش‌فرض
        Delivery delivery = deliveryRepository.findByIdAndUserAccountId(id, userAccountId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setDefault(true);
        deliveryRepository.save(delivery);
    }
}
