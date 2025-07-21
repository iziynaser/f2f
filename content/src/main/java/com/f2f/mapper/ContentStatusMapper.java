package com.f2f.mapper;

import com.f2f.dto.ContentStatusDTO;
import com.f2f.entity.ContentStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContentStatusMapper {

    ContentStatusDTO toDto(ContentStatus contentStatus);

    ContentStatus toEntity(ContentStatusDTO dto);

    List<ContentStatusDTO> toDtoList(List<ContentStatus> list);

    List<ContentStatus> toEntityList(List<ContentStatusDTO> dtoList);
}
