package ir.verjik.adapter;

import ir.verjik.dto.DeliveryDTO;
import ir.verjik.port.DeliveryAccessPort;
import ir.verjik.service.DeliveryService;
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
