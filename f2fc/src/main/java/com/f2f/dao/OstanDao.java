package com.f2f.dao;

import com.f2f.entity.other.Ostan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("OstanDao")
@Repository
public interface OstanDao extends JpaRepository<Ostan,Long> {

}
