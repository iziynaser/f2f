package ir.verjik.service;

import ir.verjik.dto.PurchaseOrderDTO;
import ir.verjik.entity.PurchaseOrder;
import ir.verjik.entity.PurchaseOrderItem;
import ir.verjik.enums.PurchaseOrderStatus;
import ir.verjik.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrder createOrder(PurchaseOrderDTO dto) {
        PurchaseOrder order = new PurchaseOrder();
        order.setOrderNumber(dto.getOrderNumber());
        //order.setSupplier(new com.f2f.entity.PersonEntity(dto.getSupplierId()));
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(PurchaseOrderStatus.valueOf(dto.getStatus()));

        List<PurchaseOrderItem> items = dto.getItems().stream().map(itemDto -> {
            PurchaseOrderItem item = new PurchaseOrderItem();
            item.setPurchaseOrder(order);
            item.setProductItemId(itemDto.getProductItemId());
            item.setQuantity(itemDto.getQuantity());
            item.setUnitPrice(itemDto.getUnitPrice());
            item.setTotalPrice(
                    itemDto.getUnitPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity()))
            );
            return item;
        }).collect(Collectors.toList());

        order.setItems(items);
        order.setTotalAmount(items.stream()
                .map(PurchaseOrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return purchaseOrderRepository.save(order);
    }

    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder getOrderById(Long id) {
        return purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
    }
}
