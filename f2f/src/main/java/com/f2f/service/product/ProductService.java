package com.f2f.service.product;

import com.f2f.dao.comment.CommentDTO;
import com.f2f.dao.product.FeaturesDTO;
import com.f2f.dao.product.ProductDao;
import com.f2f.dao.product.ProductFeatureGroupDao;
import com.f2f.entity.common.Comment;
import com.f2f.entity.common.CommentTarget;
import com.f2f.entity.product.NameValueDTO;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductDTO;
import com.f2f.service.comment.CommentTargetService;
<<<<<<< Updated upstream:src/main/java/com/f2f/service/product/ProductService.java
import com.revengemission.sso.oauth2.server.domain.EntityNotFoundException;
import com.revengemission.sso.oauth2.server.domain.UserAccount;
import com.revengemission.sso.oauth2.server.persistence.entity.UserAccountEntity;
=======
import com.f2f.domain.EntityNotFoundException;
>>>>>>> Stashed changes:f2f/src/main/java/com/f2f/service/product/ProductService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@PreAuthorize("isAuthenticated()")
public class ProductService {

    @Autowired
    ProductDao productDao ;

    @Autowired
    CommentTargetService commentTargetService;

    @Autowired
    ProductFeatureGroupDao productFeatureGroupDao ;

    @PreAuthorize("hasRole('FIND_PRODUCT')")
    public List<String> findAllByNameContains(String name) {
       return (List<String>) productDao.findAllByNameContains(name);
    }

    @PreAuthorize("hasRole('FIND_PRODUCT')")
    public List<ProductDTO> findAllAvailableProducts() {
        return  productDao.findAllAvailableProducts();
    }

    @PreAuthorize("hasRole('SAVE_PRODUCT')")
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
}
