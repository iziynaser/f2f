package com.f2f.repository;

import com.f2f.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PImageRepository extends JpaRepository<ProductImage,Long> {

    public Optional<ProductImage> findByName(String name);
}
