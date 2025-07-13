package com.f2f.mapper;

import com.f2f.dto.InvoiceDTO;
import com.f2f.entity.PersonEntity;
import com.f2f.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InvoiceItemMapper.class})
public interface InvoiceMapper {

    @Mapping(source = "referenceInvoice.id", target = "referenceInvoice")
    @Mapping(source = "creatorPerson.id", target = "creatorPerson")
    @Mapping(source = "fromPerson.id", target = "fromPerson")
    @Mapping(source = "toPerson.id", target = "toPerson")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "invoiceType", target = "invoiceType")
    @Mapping(source = "orderId", target = "orderId") // فقط فیلد long
    InvoiceDTO toDto(Invoice entity);

    @Mapping(source = "referenceInvoice", target = "referenceInvoice")
    @Mapping(source = "creatorPerson", target = "creatorPerson")
    @Mapping(source = "fromPerson", target = "fromPerson")
    @Mapping(source = "toPerson", target = "toPerson")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "invoiceType", target = "invoiceType")
    @Mapping(source = "orderId", target = "orderId") // فقط فیلد long
    Invoice toEntity(InvoiceDTO dto);

    default PersonEntity fromIdToPerson(Long id) {
        if (id == null) return null;
        PersonEntity p = new PersonEntity();
        p.setId(id);
        return p;
    }

    default Invoice fromIdToInvoice(Long id) {
        if (id == null) return null;
        Invoice invoice = new Invoice();
        invoice.setId(id);
        return invoice;
    }

    // ⚠️ حذف این متد چون دیگر کلاس Order نباید import شود
    // default Order fromIdToOrder(Long id) { ... }
}
