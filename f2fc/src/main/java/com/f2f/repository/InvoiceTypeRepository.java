package com.f2f.repository;

import com.f2f.entity.acc.invoice.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceTypeRepository extends JpaRepository<InvoiceType, Integer> {

    // جستجو بر اساس نام نوع فاکتور
    Optional<InvoiceType> findByName(String name);

}
