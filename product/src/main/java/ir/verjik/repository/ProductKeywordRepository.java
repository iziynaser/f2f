package ir.verjik.repository;

import ir.verjik.entity.Product;
import ir.verjik.entity.ProductKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductKeywordRepository extends JpaRepository<ProductKeyword,Long> {

    List<ProductKeyword> findAllByProducts(Product product);
}
