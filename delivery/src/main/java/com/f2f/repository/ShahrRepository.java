package com.f2f.repository;

import com.f2f.entity.Ostan;
import com.f2f.entity.Shahr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShahrRepository extends JpaRepository<Shahr,Long> {

    List<Shahr> getAllByOstan(Ostan ostan);

}
