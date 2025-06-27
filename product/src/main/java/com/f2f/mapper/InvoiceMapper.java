package com.f2f.mapper;

    
import com.f2f.dto.InvoiceDTO;

import com.f2f.entity.InvoiceType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {InvoiceItemMapper.class})
public interface InvoiceMapper {

//    Invoice toEntity(InvoiceDTO dto);
//
//    InvoiceDTO toDto(Invoice entity);
//
//    default InvoiceType map(String name) {
//        if (name == null) {
//            return null;
//        }
//        InvoiceType invoiceType = new InvoiceType();
//        invoiceType.setName(name);
//        return invoiceType;
//    }
//
//    default String map(InvoiceType invoiceType) {
//        if (invoiceType == null) {
//            return null;
//        }
//        return invoiceType.getName();
//    }
}
