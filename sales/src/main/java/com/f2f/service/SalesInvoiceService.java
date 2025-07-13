package com.f2f.service;

import com.f2f.dto.SalesInvoiceDTO;
import com.f2f.entity.SalesInvoice;
import com.f2f.enums.SalesStatus;
import com.f2f.repository.SalesInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesInvoiceService {

    private final SalesInvoiceRepository salesInvoiceRepository;

    public SalesInvoiceDTO createInvoice(SalesInvoiceDTO dto) {
        SalesInvoice invoice = new SalesInvoice();
        invoice.setInvoiceNumber(dto.getInvoiceNumber());
        invoice.setCustomerId(dto.getCustomerId());
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setStatus(SalesStatus.DRAFT); // وضعیت اولیه
        invoice.setTotalAmount(dto.getTotalAmount());

        SalesInvoice saved = salesInvoiceRepository.save(invoice);
        return toDTO(saved);
    }

    public List<SalesInvoiceDTO> getAllInvoices() {
        return salesInvoiceRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<SalesInvoiceDTO> getInvoiceById(Long id) {
        return salesInvoiceRepository.findById(id).map(this::toDTO);
    }

    public SalesInvoiceDTO updateStatus(Long invoiceId, SalesStatus newStatus) {
        SalesInvoice invoice = salesInvoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        invoice.setStatus(newStatus);
        SalesInvoice updated = salesInvoiceRepository.save(invoice);

        return toDTO(updated);
    }

    private SalesInvoiceDTO toDTO(SalesInvoice invoice) {
        SalesInvoiceDTO dto = new SalesInvoiceDTO();
        dto.setId(invoice.getId());
        dto.setInvoiceNumber(invoice.getInvoiceNumber());
        dto.setCustomerId(invoice.getCustomerId());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setStatus(invoice.getStatus());
        dto.setTotalAmount(invoice.getTotalAmount());
        return dto;
    }
}
