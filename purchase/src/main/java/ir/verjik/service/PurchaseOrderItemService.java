package ir.verjik.service;

import ir.verjik.entity.PurchaseOrderItem;
import ir.verjik.repository.PurchaseOrderItemRepository;
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
