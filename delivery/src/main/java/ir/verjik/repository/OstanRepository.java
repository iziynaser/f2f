package ir.verjik.repository;

import ir.verjik.entity.Ostan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OstanRepository extends JpaRepository<Ostan,Long> {

}
