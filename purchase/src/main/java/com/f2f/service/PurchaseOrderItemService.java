package com.f2f.service;

import com.f2f.entity.PurchaseOrderItem;
import com.f2f.repository.PurchaseOrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderItemService {

    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    public PurchaseOrderItem save(PurchaseOrderItem item) {
        return purchaseOrderItemRepository.save(item);
    }

    public List<PurchaseOrderItem> findAll() {
        return purchaseOrderItemRepository.findAll();
    }
}
