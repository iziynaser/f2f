package com.f2f.dao.product;

import com.f2f.entity.product.PImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("PImageRepository")
public interface PImageRepository extends JpaRepository<PImage,Long> {

    public Optional<PImage> findByName(String name);
}
