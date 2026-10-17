package ir.verjik.reporting.order.service;

import ir.verjik.mapper.OrderMapper;
import com.f2f.reporting.order.dto.*;
import ir.verjik.reporting.order.dto.CustomerOrderCountReportDTO;
import ir.verjik.reporting.order.dto.CustomerOrderDetailReportDTO;
import ir.verjik.reporting.order.dto.CustomerOrderReportReportDTO;
import ir.verjik.reporting.order.dto.OrderStatusSummaryReportDTO;
import ir.verjik.reporting.order.repository.OrderReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderReportService {

    private final OrderReportRepository orderRepository;
    private final OrderMapper orderMapper;  // فرض بر این است که mapper این تبدیل‌ها را انجام می‌دهد

    public List<CustomerOrderReportReportDTO> getOrdersForCustomer(Long customerId) {
        return orderRepository.getCustomerOrders(customerId);
    }

    public List<OrderStatusSummaryReportDTO> getOrderStatusSummary() {
        return orderRepository.countOrdersByStatus();
    }

    public List<CustomerOrderDetailReportDTO> getOrdersByCustomer(Long customerId) {
        return null;
//        List<Order> orders = orderRepository.findByCustomerId(customerId);
//        return orders.stream()
//                .map(order -> {
//                    CustomerOrderDetailReportDTO dto = new CustomerOrderDetailReportDTO();
//                    dto.setOrderId(order.getId());
//                    dto.setOrderCode(order.getOrderCode());
//                    dto.setOrderDate(order.getOrderDate());
//                    dto.setCurrentStatus(order.getCurrentStatus());
//                    dto.setStatusHistory(
//                            order.getStatusHistory().stream()
//                                    .map(status -> {
//                                        OrderStatusDetailDTO statusDTO = new OrderStatusDetailDTO();
//                                        statusDTO.setStatus(status.getStatus());
//                                        statusDTO.setStatusDate(status.getStatusDate());
//                                        statusDTO.setComment(status.getComment());
//                                        return statusDTO;
//                                    }).collect(Collectors.toList())
//                    );
//                    dto.setItems(order.getOrderItems().stream()
//                            .map(item -> {
//                                OrderItemDTO itemDTO = new OrderItemDTO();
//                                itemDTO.setProductItemId(item.getProductItemId());
//                                itemDTO.setQuantity(item.getQuantity());
//                                return itemDTO;
//                            }).collect(Collectors.toList()));
//                    return dto;
//                }).collect(Collectors.toList());
    }

    public List<CustomerOrderCountReportDTO> getCustomerOrderCounts() {
        return null;
    }
}
