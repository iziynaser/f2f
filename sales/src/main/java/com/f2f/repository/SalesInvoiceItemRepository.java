package com.f2f.repository;

import com.f2f.entity.SalesInvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesInvoiceItemRepository  extends JpaRepository<SalesInvoiceItem, Long> {}