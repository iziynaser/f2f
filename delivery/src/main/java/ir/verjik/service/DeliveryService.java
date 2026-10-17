package ir.verjik.service;


import ir.verjik.dto.DeliveryDTO;

import java.util.List;

public interface DeliveryService {

    DeliveryDTO createDelivery(DeliveryDTO dto);

    DeliveryDTO updateDelivery(Long id, DeliveryDTO dto);

    void deleteDelivery(Long id, Long userAccountId);

    DeliveryDTO getDeliveryById(Long id, Long userAccountId);

    List<DeliveryDTO> getAllDeliveriesForUser(Long userAccountId);

    void setDefaultDelivery(Long id, Long userAccountId);

    DeliveryDTO getDefaultDeliveryForUser(Long userAccountId);

}
