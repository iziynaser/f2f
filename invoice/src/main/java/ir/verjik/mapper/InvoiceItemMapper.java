package ir.verjik.mapper;

import ir.verjik.dto.InvoiceItemDTO;
import ir.verjik.entity.InvoiceItem;
import org.mapstruct.*;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper {

    InvoiceItemDTO toDto(InvoiceItem entity);

    InvoiceItem toEntity(InvoiceItemDTO dto);

    Set<InvoiceItemDTO> toDtoSet(Set<InvoiceItem> entities);

    Set<InvoiceItem> toEntitySet(Set<InvoiceItemDTO> dtos);
}
