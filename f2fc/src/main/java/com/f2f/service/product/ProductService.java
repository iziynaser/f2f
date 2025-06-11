package com.f2f.service.product;

import com.f2f.dao.ProductItemRepository;
import com.f2f.dao.ProductRepository;
import com.f2f.dao.product.FeaturesDTO;
import com.f2f.dao.product.ProductDao;
import com.f2f.dao.product.ProductFeatureGroupDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.ProductPriceDTO;
import com.f2f.dto.ProductPriceStats;
import com.f2f.entity.common.CommentTarget;
import com.f2f.dto.NameValueDTO;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductDTO;
import com.f2f.mapper.ProductMapper;
import com.f2f.service.comment.CommentTargetService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductService {

    @Autowired
    ProductDao productDao ;

    @Autowired
    CommentTargetService commentTargetService;

    @Autowired
    ProductFeatureGroupDao productFeatureGroupDao ;

    private final ProductRepository productRepository ;
    private final ProductItemRepository productItemRepository ;
    private final ProductMapper productMapper ;

    //@PreAuthorize("hasRole('FIND_PRODUCT')")
    public List<String> findAllByNameContains(String name) {
       return (List<String>) productDao.findAllByNameContains(name);
    }

    //@PreAuthorize("hasRole('FIND_PRODUCT')")
    public List<ProductDTO> findAllAvailableProducts() {
        return  productDao.findAllAvailableProducts();
    }

   // @PreAuthorize("hasRole('SAVE_PRODUCT')")
    public Product save(Product product) {
        if(product.getId()==0){
            CommentTarget commentTarget= commentTargetService.returnNewCommentTarget();
            product.setCommentTarget(commentTarget);
            Product p = productDao.save(product);
            return p;
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

         if(p.getCommentTarget()==null)
                return 0l;
            else
                return p.getCommentTarget().getId();
    }

    public void saveCommenttargetForThisProduct(Product p, CommentTarget commentTarget) {
        p.setCommentTarget(commentTarget);
        productDao.save(p);
    }

    public List<NameValueDTO> getNameValuesOfProducts() {
        List<NameValueDTO> result = productDao.getNameValuesOfProducts();
        return result;
    }

    public ProductService(ProductRepository productRepository,
                          ProductItemRepository productItemRepository,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productItemRepository = productItemRepository;
        this.productMapper = productMapper;
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