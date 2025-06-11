package com.f2f.repository;

import com.f2f.entity.acc.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesInvoiceRepository extends JpaRepository<Invoice, Long> {

    //List<Invoice> findByCustomerId(Long customerId);

    List<Invoice> findByCreatorPersonId(Long creatorPersonId);

    List<Invoice> findByOrderId(Long orderId);
}
