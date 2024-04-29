package com.f2f.dao;

import com.f2f.entity.Ostan;
import com.f2f.entity.Shahr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ShahrDao")
public interface ShahrDao extends JpaRepository<Shahr,Long> {

    //@Query("select Shahr from Shahr as s where s.ostan.id = :id")
    List<Shahr> getAllByOstan(Ostan ostan);

}
