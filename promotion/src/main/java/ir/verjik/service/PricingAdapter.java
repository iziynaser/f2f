package ir.verjik.service;

import ir.verjik.repository.PricingDao;
import ir.verjik.dto.PricingDTO;
import ir.verjik.entity.Pricing;
import ir.verjik.port.PricingPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PricingAdapter implements PricingPort {

    @Autowired
    private PricingDao pricingRepository;

    @Override
    public PricingDTO findActivePricing(Long productItemId, Long personId, LocalDateTime now) {
        Pricing pricing = pricingRepository.findActivePricing(productItemId, personId, now);
        if (pricing == null) return null;

        PricingDTO dto = new PricingDTO();
        //dto.setId(pricing.getId());
        dto.setPriceAmount(pricing.getPriceAmount());
        // مقداردهی بقیه فیلدهای DTO

        return dto;
    }
}
