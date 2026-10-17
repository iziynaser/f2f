package ir.verjik.dao;

import ir.verjik.entity.other.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("AboutUsDao")
@Repository
public interface AboutUsDao extends JpaRepository<AboutUs,Long> {

}
