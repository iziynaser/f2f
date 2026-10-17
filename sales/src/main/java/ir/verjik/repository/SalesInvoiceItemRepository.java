package ir.verjik.repository;

import ir.verjik.entity.SalesInvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesInvoiceItemRepository  extends JpaRepository<SalesInvoiceItem, Long> {}