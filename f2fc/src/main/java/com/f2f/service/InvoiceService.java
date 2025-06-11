package com.f2f.service;

import com.f2f.entity.acc.invoice.Invoice;
import com.f2f.dto.InvoiceDTO;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    InvoiceDTO createInvoice(InvoiceDTO dto);

    Optional<InvoiceDTO> getInvoiceById(Long id);

    List<InvoiceDTO> getInvoicesByType(String invoiceType);

    //List<InvoiceDTO> getInvoicesByPartyId(Long partyId);

    List<InvoiceDTO> getInvoicesByOrderId(Long orderId);

    InvoiceDTO updateInvoice(Long id, InvoiceDTO dto);

    void deleteInvoice(Long id);

    List<InvoiceDTO> findAllAvailableInvoice();

    void save(Invoice invoice);
}
