package ir.verjik.service;

import ir.verjik.dto.OrderStatusDTO;
import ir.verjik.entity.OrderStatus;
import ir.verjik.mapper.OrderStatusMapper;
import ir.verjik.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;
    private final OrderStatusMapper orderStatusMapper;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository, OrderStatusMapper orderStatusMapper) {
        this.orderStatusRepository = orderStatusRepository;
        this.orderStatusMapper = orderStatusMapper;
    }

    public OrderStatusDTO createStatus(OrderStatusDTO orderStatusDTO) {
        OrderStatus entity = orderStatusMapper.toEntity(orderStatusDTO);
        entity = orderStatusRepository.save(entity);
        return orderStatusMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<OrderStatusDTO> getStatusesByOrderId(Long orderId) {
        List<OrderStatus> statuses = orderStatusRepository.findByOrderIdOrderByStatusDateDesc(orderId);
        return statuses.stream()
                .map(orderStatusMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteStatus(Long id) {
        orderStatusRepository.deleteById(id);
    }

    public OrderStatusDTO updateStatus(Long id, OrderStatusDTO orderStatusDTO) {
        Optional<OrderStatus> existingOpt = orderStatusRepository.findById(id);
        if (existingOpt.isPresent()) {
            OrderStatus existing = existingOpt.get();
            existing.setStatus(orderStatusDTO.getStatus());
            existing.setStatusDate(orderStatusDTO.getStatusDate());
            existing.setComment(orderStatusDTO.getComment());
            existing.setStartDate(orderStatusDTO.getStartDate());
            existing.setEndDate(orderStatusDTO.getEndDate());
            existing.setRegisterDate(orderStatusDTO.getRegisterDate());
            existing.setDeliveryDate(orderStatusDTO.getDeliveryDate());

            existing = orderStatusRepository.save(existing);
            return orderStatusMapper.toDto(existing);
        }
        throw new RuntimeException("OrderStatus not found with id: " + id);
    }
}
