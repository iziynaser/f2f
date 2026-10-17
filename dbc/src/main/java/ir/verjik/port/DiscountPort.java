package ir.verjik.port;

import ir.verjik.dto.DiscountDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface DiscountPort {
    List<DiscountDTO> findActiveDiscounts(Long productItemId, Long personId, LocalDateTime now);
}