package com.f2f.service;

import com.f2f.dao.OrderStatusRepository;
import com.f2f.dto.OrderStatusDTO;
import com.f2f.entity.OrderStatus;
import com.f2f.mapper.OrderStatusMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
@Transactional
public class OrderStatusServiceImpl  implements OrderStatusService {

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

    @Override
    public DoubleStream getStatusById(Long id) {
        return DoubleStream.empty();
    }

//    @Transactional(readOnly = true)
//    public Optional<OrderStatusDTO> getStatusById(Long id) {
//        return orderStatusRepository.findById(id)
//                .map(orderStatusMapper::toDto);
//    }

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
            existing = orderStatusRepository.save(existing);
            return orderStatusMapper.toDto(existing);
        }
        return null;
    }



}
