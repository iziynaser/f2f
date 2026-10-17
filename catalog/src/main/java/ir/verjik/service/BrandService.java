package ir.verjik.service;

import ir.verjik.dto.BrandDTO;
import ir.verjik.dto.ProductItemDTO;
import ir.verjik.entity.Category;
import ir.verjik.entity.Brand;
import ir.verjik.port.ProductItemPort;
import ir.verjik.repository.BrandRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("BrandService")
public class BrandService {

    private final BrandRepository brandRepository;

    private final ProductItemPort productItemRepository;

    public BrandService(BrandRepository brandRepository, ProductItemPort productItemRepository) {
        this.brandRepository = brandRepository;
        this.productItemRepository = productItemRepository;
    }

    public List<Brand> findAll(){
        return (List<Brand>) brandRepository.findAll();
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    public void delete(Brand b) {
        brandRepository.delete(b);
    }

    public List<Brand> getAllBrandsByCategoryId(Category category){
        List<Brand> brands = brandRepository.findBrandsByCategory(category.getId());
        return brands;
    }

    public String getBrandNameByProductItemId(Long productItemId) {
        ProductItemDTO productItem = productItemRepository.findById(productItemId)
                .orElseThrow(() -> new RuntimeException("Product Item with ID " + productItemId + " not found"));

        BrandDTO brand = productItem.getBrand();
        return (brand != null && brand.getName() != null) ? brand.getName() : "unknown";
    }

}
