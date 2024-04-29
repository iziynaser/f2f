package com.f2f.dao;

import com.f2f.entity.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AboutUsDao")
public interface AboutUsDao extends JpaRepository<AboutUs,Long> {

}
