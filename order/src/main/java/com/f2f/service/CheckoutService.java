package com.f2f.service;

import com.f2f.dto.CreateOrderRequest;
import com.f2f.dto.OrderDTO;

import java.util.Optional;

public interface CheckoutService {
    Optional<OrderDTO>  submitOrder(CreateOrderRequest request);
}
