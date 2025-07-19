package com.f2f.adapter;

import com.f2f.port.ProductSalesPort;
import org.springframework.stereotype.Component;

import java.util.List;

// SalesAdapter.java در ماژول sales
@Component
public class SalesAdapter implements ProductSalesPort {
//    private final SalesRepository salesRepository;
//
//    public SalesAdapter(SalesRepository salesRepository) {
//        this.salesRepository = salesRepository;
//    }

    @Override
    public List<Long> getTopSellingProductIdsInLastDays(int days, int limit) {
       // return salesRepository.findTopSellingProductIds(days, limit);
        return null;
    }
}
