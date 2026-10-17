package ir.verjik.controller;

import ir.verjik.dto.Context;
import ir.verjik.dto.PriceCalculationResult;
import ir.verjik.dto.ProductPriceResponseDTO;
import ir.verjik.entity.ProductItem;
import ir.verjik.port.PriceCalculationPort;
import ir.verjik.repository.ProductItemRepository;
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
