package com.f2f.dao;

import com.f2f.entity.Catalog;
import com.f2f.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    List<Catalog> findByLocale(String locale);
    //Catalog findById(long id);
    //Set<Product> findProductsByCatalog(Catalog catalog);
    //findCatalogByIdIs(Long ca)
    //Set<Product> findProductByCatalogId(@Param("catalogId") Long catalogId);

    @Query("select p from Product as p where p.categoryId = :categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") long categoryId);

}
