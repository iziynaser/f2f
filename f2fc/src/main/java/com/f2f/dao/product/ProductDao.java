package com.f2f.dao.product;

import com.f2f.dto.NameValueDTO;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

//@Repository("ProductDao")
@Repository
public interface ProductDao extends CrudRepository<Product,Long> {

    List<String> findAllByNameContains(String productName);

    //Product findProductById(Long id);

//    @Override
//    Optional<Product> findById(Long id);

    @Query("select p.name as name,p.comment as comment," +
            "p.isVirtual as isVirtual,p.releaseDate as releaseDate,p.productCode as productCode," +
            "p.introDate as introDate,p.internalName as internalName,p.disContinuedDate as disContinuedDate from Product as p ")
    List<Tuple> findAllAvailableProducts();

    @Query("select p.id as id ,p.name as name from Product  p")
    List<NameValueDTO> getNameValuesOfProducts();
}
