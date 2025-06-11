package com.f2f.mapper;

import com.f2f.dto.InvoiceItemDTO;
import com.f2f.entity.acc.invoice.InvoiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper {

//    @Mapping(target = "productItem.id", source = "productItemId")
//    InvoiceItem toEntity(InvoiceItemDTO dto);
//
//    @Mapping(source = "productItem.id", target = "productItemId")
//    InvoiceItemDTO toDto(InvoiceItem entity);
//
//    List<InvoiceItem> toEntityList(List<InvoiceItemDTO> dtoList);
//
//    List<InvoiceItemDTO> toDtoList(List<InvoiceItem> entityList);
}


