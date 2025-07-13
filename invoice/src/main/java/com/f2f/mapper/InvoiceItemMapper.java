package com.f2f.mapper;

import com.f2f.dto.InvoiceItemDTO;
import com.f2f.entity.InvoiceItem;
import org.mapstruct.*;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper {

    InvoiceItemDTO toDto(InvoiceItem entity);

    InvoiceItem toEntity(InvoiceItemDTO dto);

    // اگر لازم بود لیست هم تبدیل شود
    Set<InvoiceItemDTO> toDtoSet(Set<InvoiceItem> entities);

    Set<InvoiceItem> toEntitySet(Set<InvoiceItemDTO> dtos);
}
