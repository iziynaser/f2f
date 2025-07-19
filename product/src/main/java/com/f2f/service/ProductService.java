package com.f2f.service;

import com.f2f.dao.*;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dbc.dto.NameValueDTO;
import com.f2f.dto.*;
import com.f2f.dto.ProductDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductItem;
import com.f2f.mapper.ProductMapper;
import com.f2f.port.*;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private final ProductDao productDao;
    private final CommentLikeSummaryService likesSummaryService;
    private final ImageAccessService imageAccessService;
    private final ProductColorService productColorService;
    private final ProductItemService productItemService;
    private final ProductFeatureGroupDao productFeatureGroupDao;
    private final ProductRepository productRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductMapper productMapper;
    private final PriceCalculationPort priceCalculationPort;
    private final InventoryPort inventoryPort;
    private final DiscountPort discountPort;

    private final BrandPort brandPort;
    private final ProductCategoriesPort productCategoriesPort;

    public ProductService(ProductDao productDao, ProductRepository productRepository,
                          ProductItemRepository productItemRepository,
                          ProductMapper productMapper,
                          ImageAccessService imageAccessService,
                          ProductColorService productColorService,
                          CommentLikeSummaryService likesSummaryService,
                          ProductItemService productItemService,
                          ProductFeatureGroupDao productFeatureGroupDao,
                          PriceCalculationPort priceCalculationPort,
                          InventoryPort inventoryPort,
                          DiscountPort discountPort,
                          BrandPort brandPort,
                          ProductCategoriesPort productCategoriesPort) {
        this.productDao = productDao;
        this.productRepository = productRepository;
        this.productItemRepository = productItemRepository;
        this.productMapper = productMapper;
        this.imageAccessService = imageAccessService;
        this.productColorService = productColorService;
        this.likesSummaryService = likesSummaryService;
        this.productItemService = productItemService;
        this.productFeatureGroupDao = productFeatureGroupDao;
        this.priceCalculationPort = priceCalculationPort;
        this.inventoryPort = inventoryPort;
        this.discountPort = discountPort;
        this.brandPort = brandPort;
        this.productCategoriesPort = productCategoriesPort;
    }

    public List<String> findAllByNameContains(String name) {
        return productDao.findAllByNameContains(name);
    }

    public List<ProductDTO> findAllAvailableProducts() {
        List<ProductInfo> allAvailableProducts = productDao.findAllAvailableProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();

        allAvailableProducts.forEach(product -> {
            ProductDTO dto = new ProductDTO();
            dto.setId(product.getId().toString());
            dto.setName(product.getName());
            dto.setComment(product.getComment());
            dto.setIsVirtual(product.getIsVirtual());
            dto.setReleaseDate(product.getReleaseDate());
            dto.setProductCode(product.getProductCode());
            dto.setIntroDate(product.getIntroDate());
            dto.setInternalName(product.getInternalName());
            dto.setDisContinuedDate(product.getDisContinuedDate());

            dto.setCardImageUrl(
                    imageAccessService.getCardImageUrlForProduct(product.getId())
                            .orElse("/images/default-card.jpg")
            );

            try {
                CommentLikeSummaryDTO likeSummary = likesSummaryService.getLikeSummaryByTargetId(Long.valueOf(dto.getId()));
                if (likeSummary != null) {
                    dto.setTotalLikes(likeSummary.getTotalLikes());
                    dto.setTotalDislikes(likeSummary.getTotalDislikes());
                }
            } catch (Exception e) {
                System.out.println("Like Summary Error: " + e.getMessage());
            }

            try {
                List<ProductColorDTO> colorList = productColorService.getListOfProductColors(product.getId());
                if (colorList != null && !colorList.isEmpty()) {
                    List<ProductColorDTO> uniqueColors = colorList.stream()
                            .filter(c -> c.getCode() != null && !c.getCode().isBlank())
                            .collect(Collectors.collectingAndThen(
                                    Collectors.toMap(ProductColorDTO::getCode, c -> c, (c1, c2) -> c1),
                                    map -> new ArrayList<>(map.values())
                            ));
                    dto.setColors(uniqueColors);
                } else {
                    ProductColorDTO defaultColor = new ProductColorDTO();
                    defaultColor.setName("پیش‌فرض");
                    defaultColor.setCode("white");
                    dto.setColors(List.of(defaultColor));
                }
            } catch (Exception e) {
                ProductColorDTO defaultColor = new ProductColorDTO();
                defaultColor.setName("پیش‌فرض");
                defaultColor.setCode("white");
                dto.setColors(List.of(defaultColor));
            }

            try {
                Optional<ProductItem> optionalItem = productItemService.findMainItemForProduct(product.getId());
                if (optionalItem.isPresent()) {
                    ProductItem mainItem = optionalItem.get();
                    if (mainItem.getDefaultPrice() != null) {
                        long basePrice = mainItem.getDefaultPrice();

                        Context context = new Context();
                        //context.setBrandId(mainItem.getBrand() != null ? mainItem.getBrand().getId() : null);
                        context.setBrandId(mainItem.getBrandId());
                        context.setGeoLocation("TEHRAN");
                        context.setQuantity(1);
                        context.setRequestDate(LocalDate.now());
                        //context.//put("productId", productItem.getProduct().getId());
                        context.setProductItemId(mainItem.getId());

                        PriceCalculationResult result = priceCalculationPort.calculateFinalPriceWithDetail(basePrice, context);

                        dto.setBasePrice(basePrice);
                        dto.setFinalPrice(result.getFinalPrice());
                        dto.setDiscountAmount(basePrice - result.getFinalPrice());
                        dto.setAppliedRuleName(result.getAppliedRuleName());

                        if (result.getNonFinancialDiscounts() != null) {
                            dto.setNonFinancialBenefits(result.getNonFinancialDiscounts());
                        }
                    }

                    int remainCount = inventoryPort.getRemainingCountByProductItemId(mainItem.getId());
                    dto.setAvailable(remainCount > 0);
                    dto.setQuantity(remainCount);

                    //brand
                    if (mainItem.getBrandId() != null) {
                        brandPort.findById(mainItem.getBrandId())
                                .ifPresent(dto::setBrand);
                    }


//                    // دسته‌بندی اصلی (از ProductCategories)
//                    ProductCategories primaryCategory = productCategoriesService.getPrimaryCategoryForProduct(product.getId());
//                    if (primaryCategory != null && primaryCategory.getCategory() != null) {
//                        Category category = primaryCategory.getCategory();
//                        CategoryDTO categoryDTO = new CategoryDTO();
//                        categoryDTO.setName(category.getName());
//                        categoryDTO.setCategoryCode(category.getCategoryCode());
//                        categoryDTO.setDescription(category.getDescription());
//                        if (category.getParentCategory() != null) {
//                            categoryDTO.setParentCategory(category.getParentCategory().getName());
//                        }
//                        if (category.getCategoryType() != null) {
//                            categoryDTO.setCategoryType(category.getCategoryType().getName());
//                        }
//                        dto.setCategory(categoryDTO);
//                    }
                }
            } catch (Exception e) {
                System.out.println("Price calculation error for product ID " + product.getId() + ": " + e.getMessage());
            }

            productDTOList.add(dto);
        });

        return productDTOList;
    }

    public Product save(Product product) {
        if (product.getId() == 0) {
            return product;
        } else {
            return product;
        }
    }

    public List<FeaturesDTO> getListOfFeatures(Long productId) {
        return productFeatureGroupDao.getListOfFeatures(productId);
    }

    public Product findProductById(Long id) {
        return productDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Product findProductMainPartWithId(Long productId) {
        return productDao.findById(productId).orElseThrow(EntityNotFoundException::new);
    }

    public Long findCommentTargetNo(Long productId) {
        Product p = productDao.findById(productId).orElseThrow(EntityNotFoundException::new);
        return 0L;
    }

    public List<NameValueDTO> getNameValuesOfProducts() {
        return productDao.getNameValuesOfProducts();
    }

    public ProductItem findMainItemForProduct(Long productId) {
        Optional<ProductItem> p = productItemRepository.findFirstByProductIdOrderByIdAsc(productId);
        return p.get();
    }
}
