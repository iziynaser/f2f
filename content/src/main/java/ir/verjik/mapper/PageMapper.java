package ir.verjik.mapper;

import ir.verjik.dto.PageDTO;
import ir.verjik.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageMapper {

    @Mapping(source = "body", target = "content")
    @Mapping(source = "article.id", target = "articleId")
    PageDTO toDto(Page page);

    @Mapping(source = "content", target = "body")
    @Mapping(source = "articleId", target = "article.id")
    Page toEntity(PageDTO dto);

    List<PageDTO> toDtoList(List<Page> pages);

    List<Page> toEntityList(List<PageDTO> dtoList);
}
