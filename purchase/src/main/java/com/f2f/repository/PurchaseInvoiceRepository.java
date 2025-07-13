package com.f2f.repository;

import com.f2f.entity.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {
}
