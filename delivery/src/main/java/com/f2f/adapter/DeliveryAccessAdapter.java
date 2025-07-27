package com.f2f.adapter;

import com.f2f.dto.DeliveryDTO;
import com.f2f.port.DeliveryAccessPort;
import com.f2f.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryAccessAdapter implements DeliveryAccessPort {

    private final DeliveryService deliveryService;

    @Override
    public DeliveryDTO getDeliveryById(Long id, Long userAccountId) {
        return deliveryService.getDeliveryById(id, userAccountId);
    }
}
