package com.f2f.controller;

import com.f2f.dto.CreateOrderRequest;
import com.f2f.dto.OrderDTO;
import com.f2f.exception.ResourceNotFoundException;
import com.f2f.response.ApiSuccessResponse;
import com.f2f.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/f2f/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    @Autowired
    private MessageSource messageSource;
    private final CheckoutService checkoutService;

        @PostMapping
        public ResponseEntity<ApiSuccessResponse<OrderDTO>> submitOrder(@RequestBody CreateOrderRequest request, Locale locale) {
            OrderDTO createdOrder = checkoutService.submitOrder(request)
                    .orElseThrow(() -> new ResourceNotFoundException("order.not.registered", new Object[]{
                            request.getCustomerId(), request.getDeliveryInfo()
                    }));

            String successMsg = messageSource.getMessage("order.created.success",null,locale);
            String detailMsg = messageSource.getMessage("order.created.detail",null,locale);

            ApiSuccessResponse<OrderDTO> response = ApiSuccessResponse.<OrderDTO>builder()
                    .message(successMsg)
                    .detail(detailMsg)
                    .body(createdOrder)
                    .build();

            return ResponseEntity.ok(response);
        }

    }
