package com.f2f.service.invoice;

import com.f2f.dao.SalesInvoiceRepository;
import com.f2f.dto.InvoiceDTO;
import com.f2f.entity.invoice.Invoice;
import com.f2f.mapper.InvoiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesInvoiceServiceImpl implements SalesInvoiceService {

    private final SalesInvoiceRepository salesInvoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public SalesInvoiceServiceImpl(SalesInvoiceRepository salesInvoiceRepository,
                                   InvoiceMapper invoiceMapper) {
        this.salesInvoiceRepository = salesInvoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO dto) {
        Invoice entity = invoiceMapper.toEntity(dto);
        entity = salesInvoiceRepository.save(entity);
        return invoiceMapper.toDto(entity);
    }

    @Override
    public Optional<InvoiceDTO> getInvoiceById(Long id) {
        return salesInvoiceRepository.findById(id).map(invoiceMapper::toDto);
    }

    @Override
    public List<InvoiceDTO> getInvoicesByCustomerId(Long customerId) {
        List<Invoice> invoices = salesInvoiceRepository.findByCreatorPersonId(customerId);
        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> getInvoicesByOrderId(Long orderId) {
        List<Invoice> invoices = salesInvoiceRepository.findByOrderId(orderId);
        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO updateInvoice(Long id, InvoiceDTO dto) {
        Optional<Invoice> existingOpt = salesInvoiceRepository.findById(id);
        if (existingOpt.isPresent()) {
            Invoice existing = existingOpt.get();
            existing.setInvoiceNumber(dto.getInvoiceNumber());
            existing.setInvoiceDate(dto.getInvoiceDate());
            existing.setDueDate(dto.getDueDate());
            existing.setTotalAmount(dto.getTotalAmount());
            existing.setPaidAmount(dto.getPaidAmount());
            existing.setPaymentStatus(dto.getPaymentStatus());
            existing.setPaymentMethod(dto.getPaymentMethod());
            existing.setRemarks(dto.getRemarks());
            //existing.setOrder(dto.getOrderId() != null ? new Order(dto.getOrderId()) : null);
            existing = salesInvoiceRepository.save(existing);
            return invoiceMapper.toDto(existing);
        }
        return null;
    }

    @Override
    public void deleteInvoice(Long id) {
        salesInvoiceRepository.deleteById(id);
    }
}
