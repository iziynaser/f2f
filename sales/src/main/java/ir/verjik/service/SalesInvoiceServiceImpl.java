package ir.verjik.service;

import org.springframework.stereotype.Service;


@Service
public class SalesInvoiceServiceImpl  {
//
//    private final SalesInvoiceRepository salesInvoiceRepository;
//    private final InvoiceMapper invoiceMapper;
//
//    public SalesInvoiceServiceImpl(SalesInvoiceRepository salesInvoiceRepository,
//                                   InvoiceMapper invoiceMapper) {
//        this.salesInvoiceRepository = salesInvoiceRepository;
//        this.invoiceMapper = invoiceMapper;
//    }
//
//    @Override
//    public InvoiceDTO createInvoice(InvoiceDTO dto) {
//        Invoice entity = invoiceMapper.toEntity(dto);
//        entity = salesInvoiceRepository.save(entity);
//        return invoiceMapper.toDto(entity);
//    }
//
//    @Override
//    public Optional<InvoiceDTO> getInvoiceById(Long id) {
//        return salesInvoiceRepository.findById(id).map(invoiceMapper::toDto);
//    }
//
//    @Override
//    public List<InvoiceDTO> getInvoicesByCustomerId(Long customerId) {
//        List<Invoice> invoices = salesInvoiceRepository.findByCreatorPersonId(customerId);
//        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<InvoiceDTO> getInvoicesByOrderId(Long orderId) {
//        List<Invoice> invoices = salesInvoiceRepository.findByOrderId(orderId);
//        return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public InvoiceDTO updateInvoice(Long id, InvoiceDTO dto) {
//        Optional<Invoice> existingOpt = salesInvoiceRepository.findById(id);
//        if (existingOpt.isPresent()) {
//            Invoice existing = existingOpt.get();
//            existing.setInvoiceNumber(dto.getInvoiceNumber());
//            existing.setInvoiceDate(dto.getInvoiceDate());
//            existing.setDueDate(dto.getDueDate());
//            existing.setTotalAmount(dto.getTotalAmount());
//            existing.setPaidAmount(dto.getPaidAmount());
//            existing.setPaymentStatus(dto.getPaymentStatus());
//            existing.setPaymentMethod(dto.getPaymentMethod());
//            existing.setRemarks(dto.getRemarks());
//            //existing.setOrder(dto.getOrderId() != null ? new Order(dto.getOrderId()) : null);
//            existing = salesInvoiceRepository.save(existing);
//            return invoiceMapper.toDto(existing);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteInvoice(Long id) {
//        salesInvoiceRepository.deleteById(id);
//    }
}
