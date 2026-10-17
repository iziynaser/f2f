package ir.verjik.service;

import ir.verjik.dto.CreateOrderRequest;
import ir.verjik.dto.OrderDTO;

import java.util.Optional;

public interface CheckoutService {
    Optional<OrderDTO>  submitOrder(CreateOrderRequest request);
}
