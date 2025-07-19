package com.f2f.adapter;

import com.f2f.dao.DiscountRepository;
import com.f2f.port.ProductDiscountPort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

// DiscountAdapter.java در ماژول promotion
@Component
public class DiscountedProductIdAdapter implements ProductDiscountPort {
    private final DiscountRepository discountRepository;

    public DiscountedProductIdAdapter(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public List<Long> getDiscountedProductIds() {
        return discountRepository.findDiscountedProductIds(LocalDate.now());
    }

}
