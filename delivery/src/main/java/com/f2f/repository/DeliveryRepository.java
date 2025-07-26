package com.f2f.repository;

import com.f2f.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Optional<Delivery> findByIdAndUserAccountId(Long id, Long userAccountId);

    List<Delivery> findAllByUserAccountIdAndIsActiveTrue(Long userAccountId);

    Optional<Delivery> findFirstByUserAccountIdAndIsDefaultTrue(Long userAccountId);
}
