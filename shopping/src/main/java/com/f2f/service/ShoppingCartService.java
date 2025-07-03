package com.f2f.service;

import com.f2f.dto.AddToCartRequest;
import com.f2f.dto.ShoppingCartResponse;

public interface ShoppingCartService {
    void completeShopping(Long customerId);
}
