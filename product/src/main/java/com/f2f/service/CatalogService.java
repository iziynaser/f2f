package com.f2f.service;


import com.f2f.dao.CatalogRepository;
import com.f2f.dao.ProductItemRepository;
import com.f2f.dao.ProductRepository;
import com.f2f.dbc.dto.CatalogDto;
import com.f2f.dto.ProductPriceDTO;
import com.f2f.dto.ProductPriceStats;
import com.f2f.entity.Catalog;
import com.f2f.entity.Product;
import com.f2f.entity.ProductDTO;
import com.f2f.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    private final ProductMapper productMapper ;

    public CatalogService(CatalogRepository catalogRepository,
                          ProductMapper productMapper) {
        this.catalogRepository = catalogRepository;
        this.productMapper = productMapper;
    }

    public Catalog addProductToCatalog(Long catalogId, Long productId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        catalog.getProducts().add(product);
        return catalogRepository.save(catalog);
    }

    public Catalog removeProductFromCatalog(Long catalogId, Long productId) {
        Catalog catalog = catalogRepository.findById(catalogId)
                .orElseThrow(() -> new RuntimeException("Catalog not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        catalog.getProducts().remove(product);
        return catalogRepository.save(catalog);
    }

    public Catalog createCatalog(String name) {
        Catalog catalog = new Catalog();
        catalog.setName(name);
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
//
//    private CatalogDto toDto(Catalog catalog) {
//        if (catalog == null) return null;
//        return new CatalogDto(catalog.getId(), catalog.getName());
//    }

    public List<CatalogDto> getAllCatalogs() {

        String currentLocale = LocaleContextHolder.getLocale().getLanguage();

        List<CatalogDto> cList = new ArrayList<>();//catalogRepository.findAll().stream().map(catalog -> toDto(catalog)).collect(Collectors.toList());

        List<Catalog> catalogs = catalogRepository.findByLocale(currentLocale);
        for(int i = 0 ; i < catalogs.size() ; i++) {
            Catalog catalog = catalogs.get(i);
            CatalogDto catalogDto = toDto(catalog);
            catalogDto.setId(catalog.getId());
            catalogDto.setName(catalog.getName());
            cList.add(catalogDto);
        }
        return cList;
//        return catalogs.stream()
//                .map(catalogMapper::toDto)
//                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCatalogId(Long catalogId) {
        //Set<Product> products = productRepository.get (catalogId);
        //Optional<Catalog> c = catalogRepository.findById(catalogId);
        //if(!c.isPresent())
        //    return null;

        Random random = new Random();

        List<Product> products = productRepository.findByCatalogId(catalogId);
        for(Product product : products) {
            System.out.println(product.getDescription());
        }
        List<ProductDTO>  result = products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());

        for(ProductDTO p : result ){
            ProductPriceStats s = productItemRepository.findMinPriceStatsByProductId(Long.valueOf(p.getId()));
            ProductPriceDTO pp = new ProductPriceDTO();
            //p.setPrice(new ProductPriceDTO());
            //p.setP
            //s.getMaxPrice()
            if(s!=null)
                pp.setPrice(s.getMaxPrice().toString());
            else
                pp.setPrice(random.nextInt(100)+"");
            pp.setCurrency("USD");
            p.setPrice(pp);
            p.setType(random.nextInt(5)+"");
        }



        return result;
    }

}
