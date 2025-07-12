package com.f2f.controller;

import com.f2f.entity.PriceType;
import com.f2f.service.PriceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-types")
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
