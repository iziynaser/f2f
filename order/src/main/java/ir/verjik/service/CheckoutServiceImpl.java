package ir.verjik.service;

import com.f2f.dto.*;
import ir.verjik.dto.CreateOrderRequest;
import ir.verjik.dto.DeliveryDTO;
import ir.verjik.dto.OrderDTO;
import ir.verjik.entity.Order;
import ir.verjik.entity.PersonEntity;
import ir.verjik.enums.OrderStatusEnum;
import ir.verjik.exception.ResourceNotFoundException;
import ir.verjik.mapper.CheckoutMapper;
import ir.verjik.mapper.OrderMapper;
import ir.verjik.mapper.PersonMapper;
import ir.verjik.port.DeliveryAccessPort;
import ir.verjik.repository.OrderItemRepository;
import ir.verjik.repository.OrderRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final DeliveryAccessPort deliveryAccessPort;
    private final CheckoutMapper checkoutMapper;
    private final PersonService personService;
    private final OrderMapper orderMapper;
    private final PersonMapper personMapper;

    public CheckoutServiceImpl(OrderRepository orderRepository,OrderItemRepository orderItemRepository,
                               DeliveryAccessPort deliveryAccessPort,CheckoutMapper checkoutMapper,
                               PersonService personService,OrderMapper orderMapper,PersonMapper personMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.deliveryAccessPort = deliveryAccessPort;
        this.checkoutMapper = checkoutMapper;
        this.personService = personService;
        this.orderMapper = orderMapper;
        this.personMapper = personMapper;
    }

    private String generateOrderCode(Long customerId) {
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        int randomNumber = new Random().nextInt(9000) + 1000; // عدد رندوم 4 رقمی
        return String.format("ORD-%d-%s-%d", customerId, datePart, randomNumber);
    }

    @Override
    public Optional<OrderDTO> submitOrder(CreateOrderRequest request) {
        DeliveryDTO address = deliveryAccessPort.getDeliveryById(
                request.getDeliveryInfo().getAddressId(), request.getCustomerId());

        if (address == null) {
            throw new ResourceNotFoundException("address.not.found", new Object[]{request.getDeliveryInfo().getAddressId()});
        }

//        PersonDTO customer = personService.findById(request.getCustomerId())
//                .orElseThrow(()->new ResourceNotFoundException("customer.not.found", new Object[]{request.getCustomerId()}));
        PersonEntity customerEntity = personService.findEntityById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("customer.not.found", new Object[]{request.getCustomerId()}));


        // بررسی تکراری بودن سفارش (مثلاً اگر orderCode قبلاً ایجاد شده)
        String orderCode = generateOrderCode(request.getCustomerId());
        boolean exists = orderRepository.findByOrderCode(orderCode).isPresent();
        if (exists) {
            throw new DataIntegrityViolationException("Duplicate order code: " + orderCode);
        }

        Order orderEntity = Order.builder()
                .customer(customerEntity)
                .orderDate(LocalDateTime.now())
                .deliveryDate(LocalDate.parse(request.getDeliveryInfo().getDeliveryDay()))
                .deliveryTime(LocalTime.parse(request.getDeliveryInfo().getDeliveryTime()))
                .description(request.getNote())
                .currentStatus(OrderStatusEnum.PRE_ORDER)
                .orderCode(orderCode)
                //.version(1)
                //.sortPriority(0)
                .build();

        orderEntity = orderRepository.save(orderEntity);

        return Optional.of(orderMapper.toDto(orderEntity));
    }


}
