package com.f2f.service;

import com.f2f.dao.CategoryDao;
import com.f2f.dao.ProductCategoriesDao;
import com.f2f.dao.ProductDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Category;
import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductCategoriesService {

    @Autowired
    private ProductCategoriesDao productCategoriesDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDao productDao ;

    public ProductCategories save(Long categoryId, Long productId){

        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        Category category = optionalCategory.orElseThrow(EntityNotFoundException::new);

        Optional<Product> optionalProduct = productDao.findById(productId);
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);

        ProductCategories productCategories = new ProductCategories();
        productCategories.setProduct(product);
        productCategories.setCategory(category);

        ProductCategories pCategories  = productCategoriesDao.save(productCategories);
        return pCategories;
    }

    public List<ProductCategoriesDTO> listOfProductsRelatedToThiscategory(Long categoryId){

        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        Category category = optionalCategory.orElseThrow(EntityNotFoundException::new);

        List<ProductCategoriesDTO> productCategoriesDTOList = productCategoriesDao.listOfProductsRelatedToThiscategory(category);
        return productCategoriesDTOList;
    }

    public List<Category> getListOfCategoriesRelatedToThisProduct(Long productId){
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);
        List<Category> categories = productCategoriesDao.getListOfCategoriesRelatedToProduct(product);
        return categories;
    }

    public void deleteProductFromThisCategory(Long categoryId, Long productId) {
        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        Category category = optionalCategory.orElseThrow(EntityNotFoundException::new);

        Optional<Product> optionalProduct = productDao.findById(productId);
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);

        ProductCategories productCategories =productCategoriesDao.getFirstByCategoryAndProduct(category,product);
        productCategoriesDao.delete(productCategories);

    }

    public void deleteAllProductsByCategoryId(String categoryId) {

    }
}
