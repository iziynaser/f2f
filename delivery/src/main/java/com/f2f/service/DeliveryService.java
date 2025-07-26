package com.f2f.service;


import com.f2f.entity.other.DeliveryDTO;

import java.util.List;

public interface DeliveryService {

    DeliveryDTO createDelivery(DeliveryDTO dto);

    DeliveryDTO updateDelivery(Long id, DeliveryDTO dto);

    void deleteDelivery(Long id, Long userAccountId);

    DeliveryDTO getDeliveryById(Long id, Long userAccountId);

    List<DeliveryDTO> getAllDeliveriesForUser(Long userAccountId);

    void setDefaultDelivery(Long id, Long userAccountId);
}
