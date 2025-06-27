package com.f2f.dao.acc.invoice;

    
import com.f2f.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findByOrderId(Long orderId);
}