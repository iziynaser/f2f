package ir.verjik.repository;

import ir.verjik.entity.Brand;
import ir.verjik.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByCategory(Category category);

    @Query("""
        select b 
        from Brand b 
        where b.category.id = :categoryId
        order by b.name asc
    """)
    List<Brand> findBrandsByCategory(@Param("categoryId") Long categoryId);

}
