package ir.verjik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService {
//
//    private final PurchaseOrderRepository orderRepository;
//    private final PurchaseOrderItemRepository itemRepository;
//
//    public PurchaseOrderResponseDto registerPurchaseOrder(PurchaseOrderRequestDto requestDto) {
//        PurchaseOrder order = new PurchaseOrder();
//        order.setSupplierId(requestDto.getSupplierId());
//        order.setOrderDate(LocalDateTime.now());
//        order.setStatus("در حال بررسی");
//        order = orderRepository.save(order);
//
//        List<PurchaseOrderItem> items = requestDto.getItems().stream().map(itemDto -> {
//            PurchaseOrderItem item = new PurchaseOrderItem();
//            item.setOrder(order);
//            item.setProductItemId(itemDto.getProductItemId());
//            item.setQuantity(itemDto.getQuantity());
//            item.setUnitPrice(itemDto.getUnitPrice());
//            item.setTotalPrice((long) itemDto.getQuantity() * itemDto.getUnitPrice());
//            return item;
//        }).collect(Collectors.toList());
//
//        itemRepository.saveAll(items);
//
//        long total = items.stream().mapToLong(PurchaseOrderItem::getTotalPrice).sum();
//
//        PurchaseOrderResponseDto response = new PurchaseOrderResponseDto();
//        response.setOrderId(order.getId());
//        response.setStatus(order.getStatus());
//        response.setTotalAmount(total);
//        return response;
//    }
//
//    public PurchaseOrderDetailDto getPurchaseOrderById(Long orderId) {
//        PurchaseOrder order = orderRepository.findById(orderId).orElseThrow();
//        List<PurchaseOrderItem> items = itemRepository.findByOrderId(orderId);
//
//        List<PurchaseOrderItemDto> itemDtos = items.stream().map(i -> new PurchaseOrderItemDto(
//                i.getProductItemId(), i.getQuantity(), i.getUnitPrice())).collect(Collectors.toList());
//
//        return new PurchaseOrderDetailDto(order.getId(), order.getSupplierId(),
//                order.getOrderDate(), order.getStatus(), itemDtos);
//    }
//
//    public void changePurchaseOrderStatus(Long orderId, String newStatus, String comment) {
//        PurchaseOrder order = orderRepository.findById(orderId).orElseThrow();
//        order.setStatus(newStatus);
//        order.setComment(comment);
//        orderRepository.save(order);
//    }
//
//    public void receivePurchaseOrder(Long orderId) {
//        PurchaseOrder order = orderRepository.findById(orderId).orElseThrow();
//        List<PurchaseOrderItem> items = itemRepository.findByOrderId(orderId);
//
//        // ToDo: Send to inventory module as stock-in event or via Port
//
//        order.setStatus("دریافت شده");
//        orderRepository.save(order);
//    }
}
