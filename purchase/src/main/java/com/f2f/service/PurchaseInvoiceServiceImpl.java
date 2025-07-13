package com.f2f.service;

//import com.f2f.dao.acc.invoice.PurchaseInvoiceRepository;
//import com.f2f.dto.InvoiceDTO;
//
//import com.f2f.entity.invoice.Invoice;
//import com.f2f.mapper.InvoiceMapper;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class PurchaseInvoiceServiceImpl {
//
//    private final PurchaseInvoiceRepository purchaseInvoiceRepository;
//    private final InvoiceMapper invoiceMapper;
//
//    public PurchaseInvoiceServiceImpl(PurchaseInvoiceRepository purchaseInvoiceRepository,
//                                      InvoiceMapper invoiceMapper) {
//        this.purchaseInvoiceRepository = purchaseInvoiceRepository;
//        this.invoiceMapper = invoiceMapper;
//    }
//
//    @Override
//    public InvoiceDTO createInvoice(InvoiceDTO dto) {
//        Invoice entity = invoiceMapper.toEntity(dto);
//        entity = purchaseInvoiceRepository.save(entity);
//        return invoiceMapper.toDto(entity);
//    }
//
//    @Override
//    public Optional<InvoiceDTO> getInvoiceById(Long id) {
//        return purchaseInvoiceRepository.findById(id).map(invoiceMapper::toDto);
//    }
//
//    @Override
//    public Optional<InvoiceDTO> getInvoiceByOrderId(Long orderId) {
//        return Optional.ofNullable(purchaseInvoiceRepository.findByOrderId(orderId))
//                .map(invoiceMapper::toDto);
//    }
//
//    @Override
//    public InvoiceDTO updateInvoice(Long id, InvoiceDTO dto) {
//        Optional<Invoice> existingOpt = purchaseInvoiceRepository.findById(id);
//        if (existingOpt.isPresent()) {
//            Invoice existing = existingOpt.get();
//            existing.setInvoiceNumber(dto.getInvoiceNumber());
//            existing.setInvoiceDate(dto.getInvoiceDate());
//            existing.setTotalAmount(dto.getTotalAmount());
//            existing.setPaidAmount(dto.getPaidAmount());
//            existing.setPaymentMethod(dto.getPaymentMethod());
//            existing.setPaymentStatus(dto.getPaymentStatus());
//            //existing.setPaymentDate(dto.getPaymentDate());
//            existing.setRemarks(dto.getRemarks());
//            existing = purchaseInvoiceRepository.save(existing);
//            return invoiceMapper.toDto(existing);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteInvoice(Long id) {
//        purchaseInvoiceRepository.deleteById(id);
//    }
}
