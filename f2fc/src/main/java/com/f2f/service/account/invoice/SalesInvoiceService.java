package com.f2f.service;

import com.f2f.dto.InvoiceDTO;

import java.util.List;
import java.util.Optional;

public interface SalesInvoiceService {

    InvoiceDTO createInvoice(InvoiceDTO dto);

    Optional<InvoiceDTO> getInvoiceById(Long id);

    List<InvoiceDTO> getInvoicesByCustomerId(Long customerId);

    List<InvoiceDTO> getInvoicesByOrderId(Long orderId);

    InvoiceDTO updateInvoice(Long id, InvoiceDTO dto);

    void deleteInvoice(Long id);
}
