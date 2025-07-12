package com.f2f.dao;

import com.f2f.entity.Pricing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricingDao extends CrudRepository<Pricing,Long> {

    Optional<Pricing> findFirstByProductItemIdAndPricingType_NameAndFromDateBeforeAndThroughDateAfter(
            Long productItemId,
            String pricingTypeName,
            LocalDate fromDate,
            LocalDate throughDate
    );


    @Query("SELECT p FROM Pricing p WHERE p.productItemId = :productItemId " +
            "AND (p.personId.id = :personId OR p.personId IS NULL) " +
            "AND p.fromDate <= :now AND p.throughDate >= :now " +
            "ORDER BY p.isdefault DESC")
    Pricing findActivePricing(@Param("productItemId") Long productItemId,
                              @Param("personId") Long personId,
                              @Param("now") LocalDateTime now);


}