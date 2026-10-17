package ir.verjik.service;

import ir.verjik.dto.InvoiceDTO;

import java.util.Optional;

public interface PurchaseInvoiceService {

    InvoiceDTO createInvoice(InvoiceDTO dto);

    Optional<InvoiceDTO> getInvoiceById(Long id);

    Optional<InvoiceDTO> getInvoiceByOrderId(Long orderId);

    InvoiceDTO updateInvoice(Long id, InvoiceDTO dto);

    void deleteInvoice(Long id);
}
