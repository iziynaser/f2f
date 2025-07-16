package com.f2f.port;

import com.f2f.dto.DiscountDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface DiscountPort {
    List<DiscountDTO> findActiveDiscounts(Long productItemId, Long personId, LocalDateTime now);
    //List<Long> findDiscountedProductIds(boolean onlyActive, int limit);
}