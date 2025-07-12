package com.f2f.dao;

import com.f2f.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DiscountRepository  extends JpaRepository<Discount, Long> {

    @Query("SELECT d FROM Discount d WHERE d.productItemId = :productItemId " +
            "AND (d.personId = :personId OR d.personId IS NULL) " +
            "AND d.startDate <= :now AND d.endDate >= :now " +
            "AND d.active = true")
    List<Discount> findActiveDiscounts(@Param("productItemId") Long productItemId,
                                       @Param("personId") Long personId,
                                       @Param("now") LocalDate now);

}
