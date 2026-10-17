package ir.verjik.mapper;

import ir.verjik.dto.PersonDTO;
import ir.verjik.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "id",target = "personId")
    PersonDTO toDTO(PersonEntity entity);

    @Mapping(source = "personId",target = "id")
    PersonEntity toEntity(PersonDTO dto);
}

