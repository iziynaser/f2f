package com.f2f.mapper;

import com.f2f.dto.ContentDTO;
import com.f2f.entity.Content;
import com.f2f.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    @Mapping(target = "tags", ignore = true) // چون دستی در سرویس ست میشه
    Content toEntity(ContentDTO dto);

    @Mapping(target = "tags", expression = "java(mapTagsToStrings(content.getTags()))")
    ContentDTO toDto(Content content);

    List<ContentDTO> toDtoList(List<Content> contentList);

    @Named("mapTagsToStrings")
    default List<String> mapTagsToStrings(List<Tag> tags) {
        if (tags == null) return new ArrayList<>();
        return tags.stream().map(Tag::getName).collect(Collectors.toList());
    }
}
