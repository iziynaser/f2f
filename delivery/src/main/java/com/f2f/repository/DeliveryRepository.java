package com.f2f.repository;

import com.f2f.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Optional<Delivery> findByIdAndUserAccountId(Long id, Long userAccountId);

    List<Delivery> findAllByUserAccountIdAndIsActiveTrue(Long userAccountId);

    @Query("SELECT d FROM Delivery d WHERE d.userAccountId = :userId AND d.isDefault = true")
    Optional<Delivery> findDefaultDelivery(@Param("userId") Long userId);

}
