package com.f2f.dao;

import com.f2f.entity.Category;
import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoriesDao extends JpaRepository<ProductCategories,Long> {

        @Query("select  p.id as productId, " +
                "       p.name as productName, " +
                "       pc.fromDate as fromDate, " +
                "       pc.toDate as toDate, " +
                "       pc.description as description, " +
                "       c.id as categoryId, " +
                "       c.name as categoryName " +
                "       from " +
                "       ProductCategories as pc " +
                "       inner join Product as p " +
                "              on p = pc.product " +
                "       inner join Category as c " +
                "              on c = pc.category " +
                "       where pc.category = :category")
        List<ProductCategoriesDTO> listOfProductsRelatedToThiscategory(@Param("category") Category category);

        @Query(" select c from ProductCategories as pc " +
                   " inner join Category as c " +
                   " on pc.category = c " +
                   " where pc.product = :product " )
        List<Category> getListOfCategoriesRelatedToProduct(@Param("product") Product product);
        ProductCategories getFirstByCategoryAndProduct(Category category, Product product);

}
