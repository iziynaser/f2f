package com.f2f.port;


import com.f2f.dto.DeliveryDTO;

public interface DeliveryAccessPort {
    DeliveryDTO getDeliveryById(Long id, Long userAccountId);
}
