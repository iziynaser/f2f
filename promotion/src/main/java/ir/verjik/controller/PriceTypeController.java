package ir.verjik.controller;

import ir.verjik.entity.PriceType;
import ir.verjik.service.PriceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price-types")
@RequiredArgsConstructor
public class PriceTypeController {

    private final PriceTypeService priceTypeService;

    @GetMapping
    public List<PriceType> getPriceTypes() {
        return priceTypeService.findAll();
    }

    @PostMapping
    public PriceType save(@RequestBody PriceType priceType) {
        return priceTypeService.save(priceType);
    }
}
