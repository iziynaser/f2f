package com.f2f.controller;

import com.f2f.dto.CatalogCreationRequest;
import com.f2f.entity.Catalog;
import com.f2f.service.DynamicCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.f2f.entity.Catalog;
import com.f2f.service.DynamicCatalogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/dynamic-catalog")
public class DynamicCatalogController {

    private final DynamicCatalogService dynamicCatalogService;

    public DynamicCatalogController(DynamicCatalogService dynamicCatalogService) {
        this.dynamicCatalogService = dynamicCatalogService;
    }

    @PostMapping("/hot")
    public Catalog createHotCatalog(@RequestParam(defaultValue = "12") int hours) {
        return dynamicCatalogService.createHotProductsCatalog(hours);
    }

    @PostMapping("/bestsellers")
    public Catalog createBestSellersCatalog() {
        return dynamicCatalogService.createBestSellerCatalog();
    }

    @PostMapping("/discounted")
    public Catalog createDiscountedCatalog() {
        return dynamicCatalogService.createDiscountedCatalog();
    }
}
