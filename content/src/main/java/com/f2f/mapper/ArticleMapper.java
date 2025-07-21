package com.f2f.mapper;

import com.f2f.dto.ArticleDTO;
import com.f2f.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleDTO toDto(Article article);

    Article toEntity(ArticleDTO dto);

    List<ArticleDTO> toDtoList(List<Article> articles);

    List<Article> toEntityList(List<ArticleDTO> dtoList);
}
