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
import com.f2f.repository.ProductFeatureGroupRepository;
import com.f2f.repository.ProductItemRepository;
import com.f2f.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private final CommentLikeSummaryService likesSummaryService;
    private final ImageAccessPort imageAccessService;
    private final ProductColorService productColorService;
    private final ProductItemService productItemService;
    private final ProductFeatureGroupRepository productFeatureGroupRepository;
    private final ProductRepository productRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductMapper productMapper;
    private final PriceCalculationPort priceCalculationPort;
    private final InventoryPort inventoryPort;
    private final DiscountPort discountPort;

    private final BrandPort brandPort;
    private final ProductCategoriesPort productCategoriesPort;

    public ProductService( ProductRepository productRepository,
                          ProductItemRepository productItemRepository,
                          ProductMapper productMapper,
                          ImageAccessPort imageAccessService,
                          ProductColorService productColorService,
                          CommentLikeSummaryService likesSummaryService,
                          ProductItemService productItemService,
                          ProductFeatureGroupRepository productFeatureGroupRepository,
                          PriceCalculationPort priceCalculationPort,
                          InventoryPort inventoryPort,
                          DiscountPort discountPort,
                          BrandPort brandPort,
                          ProductCategoriesPort productCategoriesPort) {
        this.productRepository = productRepository;
        this.productItemRepository = productItemRepository;
        this.productMapper = productMapper;
        this.imageAccessService = imageAccessService;
        this.productColorService = productColorService;
        this.likesSummaryService = likesSummaryService;
        this.productItemService = productItemService;
        this.productFeatureGroupRepository = productFeatureGroupRepository;
        this.priceCalculationPort = priceCalculationPort;
        this.inventoryPort = inventoryPort;
        this.discountPort = discountPort;
        this.brandPort = brandPort;
        this.productCategoriesPort = productCategoriesPort;
    }

    public List<String> findAllByNameContains(String name) {
        return productRepository.findAllByNameContains(name);
    }

    public List<ProductDTO> findAllAvailableProducts() {
        List<ProductInfo> allAvailableProducts = productRepository.findAllAvailableProducts();
        return allAvailableProducts.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToProductDTO(ProductInfo product) {
        ProductDTO dto = new ProductDTO();

        setBasicProductInfo(dto, product);
        setCardImageUrl(dto, product.getId());
        setLikeSummary(dto);
        setProductColors(dto, product.getId());
        setPriceInventoryBrandCategory(dto, product);

        return dto;
    }

    private void setBasicProductInfo(ProductDTO dto, ProductInfo product) {
        dto.setId(product.getId().toString());
        dto.setName(product.getName());
        dto.setComment(product.getComment());
        dto.setIsVirtual(product.getIsVirtual());
        dto.setReleaseDate(product.getReleaseDate());
        dto.setProductCode(product.getProductCode());
        dto.setIntroDate(product.getIntroDate());
        dto.setInternalName(product.getInternalName());
        dto.setDisContinuedDate(product.getDisContinuedDate());
    }

    private void setCardImageUrl(ProductDTO dto, Long productId) {
        String url = imageAccessService.getCardImageUrlForProduct(productId)
                .orElse("/images/default-card.jpg");
        dto.setCardImageUrl(url);
    }

    private void setLikeSummary(ProductDTO dto) {
        try {
            CommentLikeSummaryDTO likeSummary = likesSummaryService.getLikeSummaryByTargetId(Long.valueOf(dto.getId()));
            if (likeSummary != null) {
                dto.setTotalLikes(likeSummary.getTotalLikes());
                dto.setTotalDislikes(likeSummary.getTotalDislikes());
            }
        } catch (Exception e) {
            System.out.println("Like Summary Error: " + e.getMessage());
        }
    }

    private void setProductColors(ProductDTO dto, Long productId) {
        try {
            List<ProductColorDTO> colorList = productColorService.getListOfProductColors(productId);
            if (colorList != null && !colorList.isEmpty()) {
                List<ProductColorDTO> uniqueColors = colorList.stream()
                        .filter(c -> c.getCode() != null && !c.getCode().isBlank())
                        .collect(Collectors.collectingAndThen(
                                Collectors.toMap(ProductColorDTO::getCode, c -> c, (c1, c2) -> c1),
                                map -> new ArrayList<>(map.values())
                        ));
                dto.setColors(uniqueColors);
            } else {
                setDefaultColor(dto);
            }
        } catch (Exception e) {
            setDefaultColor(dto);
        }
    }

    private void setDefaultColor(ProductDTO dto) {
        ProductColorDTO defaultColor = new ProductColorDTO();
        defaultColor.setName("پیش‌فرض");
        defaultColor.setCode("white");
        dto.setColors(List.of(defaultColor));
    }

    private void setPriceInventoryBrandCategory(ProductDTO dto, ProductInfo product) {
        try {
            Optional<ProductItem> optionalItem = productItemService.findMainItemForProduct(product.getId());
            if (optionalItem.isPresent()) {
                ProductItem mainItem = optionalItem.get();

                if (mainItem.getDefaultPrice() != null) {
                    long basePrice = mainItem.getDefaultPrice();

                    Context context = new Context();
                    context.setBrandId(mainItem.getBrandId());
                    context.setGeoLocation("TEHRAN");
                    context.setQuantity(1);
                    context.setRequestDate(LocalDate.now());
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

                if (mainItem.getBrandId() != null) {
                    brandPort.findById(mainItem.getBrandId())
                            .ifPresent(dto::setBrand);
                }

                Optional<ProductCategoriesDTO> primaryCategory = productCategoriesPort.getPrimaryCategoryForProduct(product.getId());
                if (primaryCategory.isPresent()) {
                    ProductCategoriesDTO primaryCategoryDTO = primaryCategory.get();
                    CategoryDTO categoryDTO = new CategoryDTO();
                    categoryDTO.setName(primaryCategoryDTO.getCategoryName());
                    categoryDTO.setCategoryCode(String.valueOf(primaryCategoryDTO.getCategoryId()));
                    dto.setCategory(categoryDTO);
                }
            }
        } catch (Exception e) {
            System.out.println("Price calculation error for product ID " + product.getId() + ": " + e.getMessage());
        }
    }

    public Product save(Product product) {
        if (product.getId() == 0) {
            return product;
        } else {
            return product;
        }
    }

    public List<FeaturesDTO> getListOfFeatures(Long productId) {
        return productFeatureGroupRepository.getListOfFeatures(productId);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Product findProductMainPartWithId(Long productId) {
        return productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
    }

    public Long findCommentTargetNo(Long productId) {
        Product p = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
        return 0L;
    }

    public List<NameValueDTO> getNameValuesOfProducts() {
        return productRepository.getNameValuesOfProducts();
    }

    public ProductItem findMainItemForProduct(Long productId) {
        Optional<ProductItem> p = productItemRepository.findFirstByProductIdOrderByIdAsc(productId);
        return p.get();
    }

    public ProductDTO getProductItemInfoById(Long productId) {
        ProductInfo productInfo = productRepository.findProductItemInfoById(productId);
        if (productInfo == null) {
            return null; // یا می‌توانید Exception پرتاب کنید
        }
        return convertToProductDTO(productInfo);
    }
}
