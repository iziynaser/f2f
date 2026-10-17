package ir.verjik.service;

import ir.verjik.dbc.dto.CatalogDto;
import ir.verjik.dbc.dto.ProductDTO;
import ir.verjik.entity.Catalog;
import ir.verjik.entity.Category;
import ir.verjik.port.ProductItemPort;
import ir.verjik.port.ProductPort;
import ir.verjik.repository.CatalogRepository;
import ir.verjik.repository.CategoryRepository;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;
    private final CategoryRepository categoryRepository;

    private final ProductPort productPort;
    private final ProductItemPort productItemPort;

    public CatalogService(CatalogRepository catalogRepository, CategoryRepository categoryRepository,
                          ProductPort productPort,
                          ProductItemPort productItemPort) {
        this.catalogRepository = catalogRepository;
        this.categoryRepository = categoryRepository;
        this.productPort = productPort;
        this.productItemPort = productItemPort;
    }

    public Catalog addProductToCatalog(Long catalogId, Long productId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        if (!catalog.getProductsId().contains(productId)) {
            catalog.getProductsId().add(productId);
        }

        return catalogRepository.save(catalog);
    }

    public Catalog removeProductFromCatalog(Long catalogId, Long productId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        catalog.getProductsId().remove(productId);
        return catalogRepository.save(catalog);
    }

    public Catalog createCatalog(String name, String locale) {
        if (catalogRepository.existsByName(name)) {
            throw new IllegalArgumentException("Catalog with this name already exists");
        }

        Catalog catalog = new Catalog();
        catalog.setName(name);
        catalog.setLocale(locale);
        return catalogRepository.save(catalog);
    }

    public Optional<Catalog> getCatalogById(Long id) {
        return catalogRepository.findById(id);
    }

    public Catalog createCatalog(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    public void deleteCatalog(Long id) {
        catalogRepository.deleteById(id);
    }

    private CatalogDto toDto(Catalog catalog) {
        if (catalog == null) return null;
        return new CatalogDto(catalog.getId(), catalog.getName());
    }

    public List<CatalogDto> getAllCatalogs() {
        String currentLocale = LocaleContextHolder.getLocale().getLanguage();

        List<CatalogDto> catalogDtos = new ArrayList<>();
        List<Catalog> catalogs = catalogRepository.findByLocale(currentLocale);

        for (Catalog catalog : catalogs) {
            catalogDtos.add(toDto(catalog));
        }

        return catalogDtos;
    }

    public List<ProductDTO> getProductsByCatalogId(Long catalogId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        List<ProductDTO> products = new ArrayList<>();

        for (Long productId : catalog.getProductsId()) {
            productPort.findById(productId).ifPresent(products::add);
        }
        return products;
    }

    public Catalog removeCategoryFromCatalog(Long catalogId, Long categoryId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        catalog.getCategories().removeIf(c -> Objects.equals(c.getId(), categoryId));
        return catalogRepository.save(catalog);
    }

    public Catalog addCategoryToCatalog(Long catalogId, Long categoryId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        if (!catalog.getCategories().contains(category)) {
            catalog.getCategories().add(category);
        }
        return catalogRepository.save(catalog);
    }


    public Catalog updateCatalog(Long id, CatalogDto dto) {
        Catalog catalog = catalogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));
        catalog.setName(dto.getName());
        return catalogRepository.save(catalog);
    }

    public void delete(Long id) {
        catalogRepository.deleteById(id);
    }

    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    public Optional<Catalog> getById(Long id) {
        return catalogRepository.findById(id);
    }

}
