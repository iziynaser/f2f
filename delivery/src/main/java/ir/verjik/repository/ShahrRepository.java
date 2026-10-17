package ir.verjik.repository;

import ir.verjik.entity.Ostan;
import ir.verjik.entity.Shahr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShahrRepository extends JpaRepository<Shahr,Long> {

    List<Shahr> getAllByOstan(Ostan ostan);

}
