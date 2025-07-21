package com.f2f.mapper;

import com.f2f.dto.PageDTO;
import com.f2f.entity.Page;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageMapper {

    PageDTO toDto(Page page);

    Page toEntity(PageDTO dto);

    List<PageDTO> toDtoList(List<Page> pages);

    List<Page> toEntityList(List<PageDTO> dtoList);
}
