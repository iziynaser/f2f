package com.f2f.mapper;

import com.f2f.dto.QuestionAnswerDTO;
import com.f2f.entity.QuestionAnswer;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionAnswerMapper {

    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = "dateCreated", target = "createdAt")
    QuestionAnswerDTO toDto(QuestionAnswer entity);

    List<QuestionAnswerDTO> toDtoList(List<QuestionAnswer> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)  // چون createdAt در entity نیست
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "qaTarget", ignore = true)
    @Mapping(target = "reactions", ignore = true)
    QuestionAnswer toEntity(QuestionAnswerDTO dto);
}
