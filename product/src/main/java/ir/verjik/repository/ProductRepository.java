package ir.verjik.repository;


import ir.verjik.dbc.dto.NameValueDTO;
import ir.verjik.dto.ProductInfo;
import ir.verjik.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<String> findAllByNameContains(String productName);

    @Query("select p.id as id, p.name as name, p.comment as comment, p.isVirtual as isVirtual, p.releaseDate as releaseDate, p.productCode as productCode, p.introDate as introDate, p.internalName as internalName, p.disContinuedDate as disContinuedDate from Product p")
    List<ProductInfo> findAllAvailableProducts();

    @Query("select p.id as id ,p.name as name from Product  p")
    List<NameValueDTO> getNameValuesOfProducts();

    @Query("select p.id as id, p.name as name, p.comment as comment, p.isVirtual as isVirtual, p.releaseDate as releaseDate, p.productCode as productCode, p.introDate as introDate, p.internalName as internalName, p.disContinuedDate as disContinuedDate from Product p where p.id = :id")
    ProductInfo findProductItemInfoById(@Param("id") Long id);

    @Query("select p.id as id, p.name as name, p.comment as comment, p.isVirtual as isVirtual, " +
            "p.releaseDate as releaseDate, p.productCode as productCode, p.introDate as introDate, " +
            "p.internalName as internalName, p.disContinuedDate as disContinuedDate " +
            "from Product p join ProductCategories pc on p.id = pc.productId " +
            "where pc.category.id = :categoryId")
    List<ProductInfo> findAvailableProductsByCategory(@Param("categoryId") Long categoryId);


}
