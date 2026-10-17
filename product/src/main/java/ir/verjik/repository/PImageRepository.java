package ir.verjik.repository;

import ir.verjik.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PImageRepository extends JpaRepository<ProductImage,Long> {

    public Optional<ProductImage> findByName(String name);
}
