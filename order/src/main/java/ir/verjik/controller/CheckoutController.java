package ir.verjik.controller;

import ir.verjik.dto.CreateOrderRequest;
import ir.verjik.dto.OrderDTO;
import ir.verjik.exception.ResourceNotFoundException;
import ir.verjik.response.ApiSuccessResponse;
import ir.verjik.service.CheckoutService;
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
@RequestMapping("/checkout")
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
