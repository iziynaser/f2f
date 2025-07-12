package com.f2f.service;

import com.f2f.dao.*;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dbc.dto.NameValueDTO;
import com.f2f.dto.*;
import com.f2f.dto.ProductDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductItem;
import com.f2f.mapper.ProductMapper;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    @Autowired
    ProductDao productDao ;

//    @Autowired
//    CommentTargetService commentTargetService;

    private final CommentLikeSummaryService likesSummaryService;

    private final ImageAccessService imageAccessService ;

    private final ProductColorService productColorService ;

    private final ProductItemService productItemService;

    private final ProductFeatureGroupDao productFeatureGroupDao ;

    private final ProductRepository productRepository ;
    private final ProductItemRepository productItemRepository ;
    private final ProductMapper productMapper ;

    public ProductService(ProductRepository productRepository,
                          ProductItemRepository productItemRepository,
                          ProductMapper productMapper, ImageAccessService imageAccessService,
                          ProductColorService productColorService,
                          CommentLikeSummaryService likesSummaryService,
                          ProductItemService productItemService, ProductFeatureGroupDao productFeatureGroupDao
    ) {
        this.productRepository = productRepository;
        this.productItemRepository = productItemRepository;
        this.productMapper = productMapper;
        this.imageAccessService = imageAccessService;
        this.productColorService = productColorService;
        this.likesSummaryService = likesSummaryService ;
        this.productItemService = productItemService;
        this.productFeatureGroupDao = productFeatureGroupDao;
    }

    public List<String> findAllByNameContains(String name) {
       return (List<String>) productDao.findAllByNameContains(name);
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

            // لایک و دیس‌لایک
            try {
                CommentLikeSummaryDTO likeSummary = likesSummaryService.getLikeSummaryByTargetId(Long.valueOf(dto.getId()));
                if (likeSummary != null) {
                    dto.setTotalLikes(likeSummary.getTotalLikes());
                    dto.setTotalDislikes(likeSummary.getTotalDislikes());
                }
            } catch (Exception e) {
                System.out.println("Like Summary Error: " + e.getMessage());
            }

            // رنگ‌ها
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

            // 💰 قیمت و تخفیف
//            try {
//                ProductItem mainItem = productItemService.findMainItemForProduct(product.getId()); // متدی که آیتم اصلی را برمی‌گرداند
//                if (mainItem != null && mainItem.getDefaultPrice() != null) {
//                    Long basePrice = mainItem.getDefaultPrice();
//
//                    DiscountContext context = new DiscountContext();
//                    context.setBrandId(mainItem.getBrand() != null ? mainItem.getBrand().getId() : null);
//                    context.setGeoLocation("TEHRAN"); // می‌تونی از request کاربر یا session بگیری
//                    context.setQuantity(1);
//                    context.setRequestDate(LocalDate.now());
//                    context.setCategoryId(product.getCategoryId());
//                    context.setProductItemId(mainItem.getId());
//
//                    PriceCalculationResult result = priceCalculatorService.calculateFinalPriceWithDetail(basePrice, context);
//
//                    dto.setBasePrice(basePrice);
//                    dto.setFinalPrice(result.getFinalPrice());
//                    dto.setDiscountAmount(basePrice - result.getFinalPrice());
//                    dto.setAppliedRuleName(result.getAppliedRuleName());
//                }
//            } catch (Exception e) {
//                System.out.println("Price calculation error for product ID " + product.getId() + ": " + e.getMessage());
//            }

            productDTOList.add(dto);
        });

        return productDTOList;
    }


    public Product save(Product product) {
        if(product.getId()==0){
//            CommentTarget commentTarget= commentTargetService.returnNewCommentTarget();
//            product.setCommentTarget(commentTarget);
//            Product p = productDao.save(product);
//            return p;
            return product;
            //System.out.println(product);
        }else
            return product;
    }

    public List<FeaturesDTO> getListOfFeatures(Long productId){
        List<FeaturesDTO> list = productFeatureGroupDao.getListOfFeatures(productId);
        return list;
    }

    public Product findProductById(Long id){
        Optional<Product> optionalProduct = productDao.findById(id);
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);
        return product;
    }

    public Product findProductMainPartWithId(Long productId) {
            Optional<Product> optionalProduct = productDao.findById(productId);
            Product p =optionalProduct.orElseThrow(EntityNotFoundException::new);
            return p;
    }

    public Long findCommentTargetNo(Long productId){
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product p= optionalProduct.orElseThrow(EntityNotFoundException::new);

        return 0l;
//         if(p.getCommentTarget()==null)
//                return 0l;
//            else
//                return p.getCommentTarget().getId();
    }

//    public void saveCommenttargetForThisProduct(Product p, CommentTarget commentTarget) {
//        p.setCommentTarget(commentTarget);
//        productDao.save(p);
//    }

    public List<NameValueDTO> getNameValuesOfProducts() {
        List<NameValueDTO> result = productDao.getNameValuesOfProducts();
        return result;
    }


    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        //ProductPriceStats priceStats = productItemRepository.findPriceStatsByProductId(productId);
        ProductPriceStats priceStats = productItemRepository.findMinPriceStatsByProductId(productId);

        List<String> brands = productItemRepository.findDistinctBrandsByProductId(productId);
        List<String> colors = productItemRepository.findDistinctColorsByProductId(productId);

        ProductDTO dto = productMapper.toDTO(product);

        if (priceStats != null) {
            //dto.setMinPrice(priceStats.getMinPrice());
            //dto.setMaxPrice(priceStats.getMaxPrice());
            //dto.setAvgPrice(priceStats.getAvgPrice());
        }

        ProductPriceDTO ppriceDTO = new ProductPriceDTO();
        //ppriceDTO.setPrice(dto.getMinPrice().toString());
        dto.setPrice(ppriceDTO);

        dto.setBrands(brands);
        //dto.setColors(colors);

        return dto;
    }

    public ProductItem findMainItemForProduct(Long productId) {
        return (ProductItem) productItemRepository.findFirstByProductIdOrderByIdAsc(productId)
                .orElse(null);
    }


}