package com.f2f.service;

import com.f2f.dto.InvoiceDTO;

import java.util.Optional;

public interface PurchaseInvoiceService {

    InvoiceDTO createInvoice(InvoiceDTO dto);

    Optional<InvoiceDTO> getInvoiceById(Long id);

    Optional<InvoiceDTO> getInvoiceByOrderId(Long orderId);

    InvoiceDTO updateInvoice(Long id, InvoiceDTO dto);

    void deleteInvoice(Long id);
}
