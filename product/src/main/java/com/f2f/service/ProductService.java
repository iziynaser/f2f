package com.f2f.service;

import com.f2f.dao.*;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dbc.dto.NameValueDTO;
import com.f2f.dto.*;
import com.f2f.entity.Product;
import com.f2f.mapper.ProductMapper;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductService {

    @Autowired
    ProductDao productDao ;

//    @Autowired
//    CommentTargetService commentTargetService;

    private final ImageAccessService imageAccessService ;

    @Autowired
    ProductFeatureGroupDao productFeatureGroupDao ;

    private final ProductRepository productRepository ;
    private final ProductItemRepository productItemRepository ;
    private final ProductMapper productMapper ;

    public ProductService(ProductRepository productRepository,
                          ProductItemRepository productItemRepository,
                          ProductMapper productMapper,ImageAccessService imageAccessService) {
        this.productRepository = productRepository;
        this.productItemRepository = productItemRepository;
        this.productMapper = productMapper;
        this.imageAccessService = imageAccessService;
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
            dto.setCardImageUrl(
                    imageAccessService.getCardImageUrlForProduct(product.getId())
                            .orElse("/images/default-card.jpg")
            );
            dto.setDisContinuedDate(product.getDisContinuedDate());
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
            dto.setMinPrice(priceStats.getMinPrice());
            //dto.setMaxPrice(priceStats.getMaxPrice());
            //dto.setAvgPrice(priceStats.getAvgPrice());
        }

        ProductPriceDTO ppriceDTO = new ProductPriceDTO();
        ppriceDTO.setPrice(dto.getMinPrice().toString());
        dto.setPrice(ppriceDTO);

        dto.setBrands(brands);
        dto.setColors(colors);

        return dto;
    }


}