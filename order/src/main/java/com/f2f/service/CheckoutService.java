package com.f2f.service;

import com.f2f.dto.CreateOrderRequest;
import com.f2f.dto.OrderDTO;

public interface CheckoutService {
    OrderDTO submitOrder(CreateOrderRequest request);
}
