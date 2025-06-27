package com.f2f.service.invoice;

import com.f2f.dto.InvoiceDTO;
import com.f2f.entity.InvoiceType;
import com.f2f.entity.invoice.Invoice;
import com.f2f.entity.invoice.InvoiceItem;
import com.f2f.mapper.InvoiceMapper;
import com.f2f.repository.InvoiceRepository;
import com.f2f.repository.InvoiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @Autowired
    private InvoiceTypeRepository invoiceTypeRepository;


    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO dto) {
        Invoice entity = invoiceMapper.toEntity(dto);
        // ست کردن ارتباط ایتم‌ها با فاکتور
        Invoice finalEntity = entity;
        entity.getItems().forEach(item -> item.setInvoice(finalEntity));
        entity = invoiceRepository.save(entity);
        return invoiceMapper.toDto(entity);
    }

    @Override
    public Optional<InvoiceDTO> getInvoiceById(Long id) {
        return invoiceRepository.findById(id).map(invoiceMapper::toDto);
    }

    @Override
    public List<InvoiceDTO> getInvoicesByType(String invoiceType) {
        List<Invoice> invoices = invoiceRepository.findByInvoiceType(invoiceType);
        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
    }

//    @Override
//    public List<InvoiceDTO> getInvoicesByPartyId(Long partyId) {
//        List<Invoice> invoices = invoiceRepository.findByPartyId(partyId);
//        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
//    }

    @Override
    public List<InvoiceDTO> getInvoicesByOrderId(Long orderId) {
        List<Invoice> invoices = invoiceRepository.findByOrderId(orderId);
        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO updateInvoice(Long id, InvoiceDTO dto) {
        Optional<Invoice> existingOpt = invoiceRepository.findById(id);
        if (existingOpt.isPresent()) {
            Invoice existing = existingOpt.get();

            existing.setInvoiceNumber(dto.getInvoiceNumber());

            //existing.setInvoiceType(dto.getInvoiceType());
            // تبدیل رشته invoiceType به InvoiceType
            if (dto.getInvoiceType() != null) {
                // فرض می‌کنیم dto.getInvoiceType() شناسه (id) هست، اگر نام هست باید تغییر کند
                Integer invoiceTypeId = Integer.valueOf(dto.getInvoiceType());
                Optional<InvoiceType> invoiceTypeOpt = invoiceTypeRepository.findById(invoiceTypeId);
                invoiceTypeOpt.ifPresent(existing::setInvoiceType);
            } else {
                existing.setInvoiceType(null);
            }

            existing.setInvoiceDate(dto.getInvoiceDate());
            existing.setDueDate(dto.getDueDate());
            existing.setTotalAmount(dto.getTotalAmount());
            existing.setPaidAmount(dto.getPaidAmount());
            existing.setPaymentStatus(dto.getPaymentStatus());
            existing.setPaymentMethod(dto.getPaymentMethod());
            existing.setRemarks(dto.getRemarks());
            //existing.setPartyId(dto.getPartyId());
           // existing.setOrder(dto.getOrderId() != null ? new Order(dto.getOrderId()) : null);

            // مدیریت آیتم‌ها:
            existing.getItems().clear();
            if (dto.getItems() != null) {
                Invoice finalExisting = existing;
                dto.getItems().forEach(itemDto -> {
                    InvoiceItem item = new InvoiceItem();
                    item.setId(itemDto.getId());
                    //item.setProductItem(new ProductItem(itemDto.getProductItemId()));
                    item.setQuantity(itemDto.getQuantity());
                    item.setUnitPrice(itemDto.getUnitPrice());
                    item.setTotalPrice(itemDto.getTotalPrice());
                    item.setInvoice(finalExisting);
                    finalExisting.getItems().add(item);
                });
            }

            existing = invoiceRepository.save(existing);
            return invoiceMapper.toDto(existing);
        }
        return null;
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceDTO> findAllAvailableInvoice() {
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }
}
