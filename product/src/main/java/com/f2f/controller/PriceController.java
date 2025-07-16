package com.f2f.controller;

import com.f2f.dao.ProductItemRepository;
import com.f2f.dto.Context;
import com.f2f.dto.DiscountContext;
import com.f2f.dto.PriceCalculationResult;
import com.f2f.dto.ProductPriceResponseDTO;
import com.f2f.entity.ProductItem;
import com.f2f.port.PriceCalculationPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceCalculationPort priceCalculationPort;
    private final ProductItemRepository productItemRepository;

    public PriceController(ProductItemRepository productItemRepository, PriceCalculationPort priceCalculationPort) {
        this.productItemRepository = productItemRepository;
        this.priceCalculationPort = priceCalculationPort;
    }

    @GetMapping("/product/{productItemId}")
    public ResponseEntity<ProductPriceResponseDTO> getPriceForProductItem(
            @PathVariable Long productItemId,
            @RequestParam(required = false) Long personId,
            @RequestParam(required = false) String geoLocation,
            @RequestParam(defaultValue = "1") int quantity
    ) {
        Optional<ProductItem> itemOpt = productItemRepository.findById(productItemId);
        if (itemOpt.isEmpty()) return ResponseEntity.notFound().build();

        ProductItem item = itemOpt.get();
        long basePrice = item.getDefaultPrice();

        Context ctx = new Context();
        //ctx.setBrandId(item.getBrand() != null ? item.getBrand().getId() : null);
        ctx.setBrandId(item.getBrandId());
        ctx.setPersonId(personId);
        ctx.setGeoLocation(geoLocation);
        ctx.setQuantity(quantity);
        ctx.setRequestDate(LocalDate.now());

        PriceCalculationResult result = priceCalculationPort.calculateFinalPriceWithDetail(basePrice, ctx);

        ProductPriceResponseDTO dto = new ProductPriceResponseDTO();
        dto.setProductItemId(productItemId);
        dto.setBasePrice(basePrice);
        dto.setDiscountAmount(basePrice - result.getFinalPrice());
        dto.setFinalPrice(result.getFinalPrice());
        dto.setAppliedRuleName(result.getAppliedRuleName());

        return ResponseEntity.ok(dto);
    }
}
