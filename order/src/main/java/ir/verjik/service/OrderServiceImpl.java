package ir.verjik.service;


import ir.verjik.dbc.domain.EntityNotFoundException;
import ir.verjik.dto.OrderDTO;
import ir.verjik.dto.OrderItemDTO;
import ir.verjik.dto.OrderStatusDTO;
import ir.verjik.dto.ProductItemDTO;
import ir.verjik.entity.Order;
import ir.verjik.entity.OrderItem;
import ir.verjik.entity.OrderStatus;
import ir.verjik.entity.PersonEntity;
import ir.verjik.enums.OrderStatusEnum;
import ir.verjik.mapper.OrderMapper;
import ir.verjik.port.ImageAccessPort;
import ir.verjik.port.ProductItemPort;
import ir.verjik.repository.OrderRepository;
import ir.verjik.repository.OrderStatusRepository;
import ir.verjik.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final PersonRepository personRepository;
    private final ImageAccessPort imageAccessService;

    private final ProductItemPort productItemPort;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository,
                            OrderStatusRepository orderStatusRepository, PersonRepository personRepository, ImageAccessPort imageAccessService, ProductItemPort productItemPort) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.personRepository = personRepository;
        this.imageAccessService = imageAccessService;
        this.productItemPort = productItemPort;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);

        if (orderDTO.getCustomerId() != null) {
            PersonEntity customer = personRepository.findById(orderDTO.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + orderDTO.getCustomerId()));
            order.setCustomer(customer);
        }

        if (order.getCurrentStatus() == null) {
            order.setCurrentStatus(OrderStatusEnum.CREATED);
        }

        final Order finalOrder = order;
        if (order.getOrderItems() != null) {
            order.getOrderItems().forEach(item -> item.setOrder(finalOrder));
        }

        order.setOrderDate(order.getOrderDate() != null ? order.getOrderDate() : LocalDateTime.now());

        order = orderRepository.save(order);

        OrderStatus initialStatus = new OrderStatus();
        initialStatus.setOrder(order);
        initialStatus.setStatus(OrderStatusEnum.CREATED);
        initialStatus.setStatusDate(LocalDateTime.now());
        orderStatusRepository.save(initialStatus);

        return orderMapper.toDto(order);
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatusDTO statusDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));

        order.setCurrentStatus(statusDTO.getStatus());
        orderRepository.save(order);

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrder(order);
        orderStatus.setStatus(statusDTO.getStatus());
        orderStatus.setStatusDate(statusDTO.getStatusDate() != null ? statusDTO.getStatusDate() : LocalDateTime.now());
        orderStatus.setComment(statusDTO.getComment());

        orderStatusRepository.save(orderStatus);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDTO> getOrderById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));

        Long customerId = orderDTO.getCustomerId();
        if (customerId != null) {
            PersonEntity customer = personRepository.findById(customerId)
                    .orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + customerId));
            existingOrder.setCustomer(customer);
        }

        existingOrder.setOrderDate(orderDTO.getOrderDate());
        existingOrder.setCurrentStatus(orderDTO.getCurrentStatus());

        existingOrder.getOrderItems().clear();
        Set<OrderItem> newItems = convertOrderItems(existingOrder, orderDTO.getItems());
        existingOrder.getOrderItems().addAll(newItems);

        existingOrder = orderRepository.save(existingOrder);

        return orderMapper.toDto(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDtoList(orders);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByCustomerAndStatus(Long customerId, OrderStatusEnum status) {
        List<Order> orders;
        if (status != null) {
            orders = orderRepository.findByCustomerIdAndCurrentStatus(customerId, status);
        } else {
            orders = orderRepository.findByCustomerId(customerId);
        }
        return orderMapper.toDtoList(orders);
    }

    private Set<OrderItem> convertOrderItems(Order order, List<OrderItemDTO> itemDTOs) {
        if (itemDTOs == null) return Collections.emptySet();

        Set<OrderItem> items = new HashSet<>();
        for (OrderItemDTO dto : itemDTOs) {
            OrderItem item = new OrderItem();
            item.setProductItemId(dto.getProductItemId());
            item.setQuantity(dto.getQuantity());
            item.setOrder(order);
            // در صورت داشتن unitPrice و totalPrice در DTO، مقداردهی کن
            items.add(item);
        }
        return items;
    }

    @Override
    public List<OrderItemDTO> getOrderItemsByOrderCode(String orderCode) {
        Order order = orderRepository.findByOrderCode(orderCode)
                .orElseThrow(()-> new EntityNotFoundException("Order not found with code: " + orderCode));

        List<OrderItemDTO> dtoList = new ArrayList<>();

        for(OrderItem item : order.getOrderItems()) {
            ProductItemDTO productItemDTO = productItemPort.findById(item.getProductItemId())
            .orElse(null);

            String imageUrl= imageAccessService.getCardImageUrlForProduct(item.getProductItemId())
                    .orElse("");

            OrderItemDTO dto = new OrderItemDTO();
            dto.setProductItemId(item.getProductItemId());
            //dto.setProductTitle();
            dto.setCardImageUrl(imageUrl);
            dto.setQuantity(item.getQuantity());
            dtoList.add(dto);
        }
        return dtoList;

    }
}
