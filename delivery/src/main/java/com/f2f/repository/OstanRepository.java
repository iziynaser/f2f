package com.f2f.repository;

import com.f2f.entity.Ostan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OstanRepository extends JpaRepository<Ostan,Long> {

}
