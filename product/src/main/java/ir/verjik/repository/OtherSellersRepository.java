package ir.verjik.repository;

import ir.verjik.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherSellersRepository extends JpaRepository<Product,Long> {
}
