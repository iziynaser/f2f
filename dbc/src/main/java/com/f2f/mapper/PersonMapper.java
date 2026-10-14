package com.f2f.mapper;

import com.f2f.dto.PersonDTO;
import com.f2f.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "id",target = "personId")
    PersonDTO toDTO(PersonEntity entity);

    @Mapping(source = "personId",target = "id")
    PersonEntity toEntity(PersonDTO dto);
}

