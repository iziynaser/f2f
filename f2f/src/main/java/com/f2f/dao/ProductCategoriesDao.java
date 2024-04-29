package com.f2f.dao;

import com.f2f.entity.common.Category;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductCategories;
import com.f2f.entity.product.ProductCategoriesDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductCategoriesDao")
public interface ProductCategoriesDao extends CrudRepository<ProductCategories,Long> {

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
                "              on p.id = pc.product " +
                "       inner join Category as c " +
                "              on c.id = pc.category " +
                "       where pc.category = :category")
        List<ProductCategoriesDTO> listOfProductsRelatedToThiscategory(@Param("category") Category category);


        //@Query("select pc from ProductCategories pc where pc.category = :category and pc.product = :product")

//    @Query("select c.id,c.name, " +
//            "      c.description,c.fromDate, " +
//            "      c.toDate,c.categoryCode  " +
//            "from  ProductCategories as pc " +
//            "inner join Product as p " +
//            "on p.id = pc.product " +
//            "inner join Category as c " +
//            "on pc.category = c.id  where pc.product = :product  ")
//    List<Category> getListOfCategoriesRelatedToProduct(@Param("product") Product product);

            @Query(" select c from ProductCategories as pc " +
                   " inner join Category as c " +
                   " on pc.category = c " +
                   " where pc.product = :product " )
            List<Category> getListOfCategoriesRelatedToProduct(@Param("product") Product product);
    ProductCategories getFirstByCategoryAndProduct(Category category,Product product);

}
