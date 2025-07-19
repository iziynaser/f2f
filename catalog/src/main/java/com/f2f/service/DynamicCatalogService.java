package com.f2f.service;

import com.f2f.dto.CatalogCreationRequest;
import com.f2f.dto.CatalogFilter;
import com.f2f.dto.ProductDTO;
import com.f2f.entity.Catalog;
import com.f2f.port.*;
import com.f2f.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import com.f2f.entity.Catalog;
import com.f2f.port.ProductDiscountPort;
import com.f2f.port.ProductInventoryPort;
import com.f2f.port.ProductSalesPort;
import com.f2f.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DynamicCatalogService {

    private final ProductSalesPort salesPort;
    private final ProductInventoryPort inventoryPort;
    private final ProductDiscountPort discountPort;
    private final CatalogRepository catalogRepository;

    public DynamicCatalogService(ProductSalesPort salesPort,
                                 ProductInventoryPort inventoryPort,
                                 ProductDiscountPort discountPort,
                                 CatalogRepository catalogRepository) {
        this.salesPort = salesPort;
        this.inventoryPort = inventoryPort;
        this.discountPort = discountPort;
        this.catalogRepository = catalogRepository;
    }

    public Catalog createHotProductsCatalog(int hours) {
        List<Long> hotProductIds = salesPort.getTopSellingProductIdsInLastDays(hours / 24, 20);
        Set<Long> availableHotProducts = filterAvailableProducts(hotProductIds);
        return createCatalog("Hot Products", availableHotProducts);
    }

    public Catalog createBestSellerCatalog() {
        List<Long> bestSellers = salesPort.getTopSellingProductIdsInLastDays(30, 20);
        Set<Long> availableBestSellers = filterAvailableProducts(bestSellers);
        return createCatalog("Best Sellers", availableBestSellers);
    }

    public Catalog createDiscountedCatalog() {
        List<Long> discounted = discountPort.getDiscountedProductIds();
        Set<Long> availableDiscounted = filterAvailableProducts(discounted);
        return createCatalog("Discounted Products", availableDiscounted);
    }

    public Catalog createCatalog(String name, Set<Long> productIds) {
        Catalog catalog = new Catalog();
        catalog.setName(name);
        catalog.setProductsId(productIds);
        return catalogRepository.save(catalog);
    }

    private Set<Long> filterAvailableProducts(List<Long> productIds) {
        Set<Long> available = new HashSet<>();
        for (Long id : productIds) {
            if (inventoryPort.isProductAvailable(id)) {
                available.add(id);
            }
        }
        return available;
    }
}
