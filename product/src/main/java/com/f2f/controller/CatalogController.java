package com.f2f.controller;

import com.f2f.entity.Catalog;
import com.f2f.entity.ProductDTO;
import com.f2f.mapper.ProductMapper;
import com.f2f.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private final ProductMapper productMapper;

    public CatalogController(CatalogService catalogService, ProductMapper productMapper) {
        this.catalogService = catalogService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public Catalog createCatalog(@RequestParam String name) {
        return catalogService.createCatalog(name);
    }

    @PostMapping("/{catalogId}/products/{productId}")
    public Catalog addProductToCatalog(@PathVariable Long catalogId, @PathVariable Long productId) {
        return catalogService.addProductToCatalog(catalogId, productId);
    }

    @DeleteMapping("/{catalogId}/products/{productId}")
    public Catalog removeProductFromCatalog(@PathVariable Long catalogId, @PathVariable Long productId) {
        return catalogService.removeProductFromCatalog(catalogId, productId);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCatalogById(@PathVariable Long id) {
        return catalogService.getCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public List<ProductDTO> getAllCatalogs() {
        //return catalogService.getAllCatalogs();
        List<ProductDTO> products = catalogService.getProductsByCatalogId(new Long("2"));
        return products;

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Catalog> getCatalogById(@PathVariable Long id) {
//        return catalogService.getCatalogById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @PostMapping
//    public Catalog createCatalog(@RequestBody Catalog catalog) {
//        return catalogService.createCatalog(catalog);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalog(@PathVariable Long id) {
        catalogService.deleteCatalog(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{catalogId}/products")
    public List<ProductDTO> getCatalogProducts(@PathVariable Long catalogId) {
        List<ProductDTO> products = catalogService.getProductsByCatalogId(catalogId);
        return products;
    }

}
