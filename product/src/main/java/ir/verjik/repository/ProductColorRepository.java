package ir.verjik.repository;


import ir.verjik.dto.ProductColorDTO;
import ir.verjik.entity.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

    @Query("select distinct new ir.verjik.dto.ProductColorDTO(c.name, c.value) " +
            "from ProductItem pi " +
            "join pi.color c " +
            "where pi.product.id = :productId")
    List<ProductColorDTO> getListOfProductColors(@Param("productId") Long productId);
}
