package com.f2f.repository;

import com.f2f.dbc.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {
    Optional<CategoryType> findBySlug(String slug);
}
