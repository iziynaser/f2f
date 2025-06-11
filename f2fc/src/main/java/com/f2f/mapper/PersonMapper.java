package com.f2f.mapper;

import com.f2f.dto.PersonDTO;
import com.f2f.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(PersonEntity entity);
    PersonEntity toEntity(PersonDTO dto);
}

