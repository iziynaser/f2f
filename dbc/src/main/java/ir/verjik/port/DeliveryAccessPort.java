package ir.verjik.port;


import ir.verjik.dto.DeliveryDTO;

public interface DeliveryAccessPort {
    DeliveryDTO getDeliveryById(Long id, Long userAccountId);
}
