package ir.verjik.controller;

import ir.verjik.entity.Catalog;
import ir.verjik.service.DynamicCatalogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
